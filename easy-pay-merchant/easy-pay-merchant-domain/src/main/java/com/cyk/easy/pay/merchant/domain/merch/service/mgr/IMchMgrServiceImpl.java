package com.cyk.easy.pay.merchant.domain.merch.service.mgr;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cyk.easy.pay.common.constants.Constant;
import com.cyk.easy.pay.common.constants.RedisKey;
import com.cyk.easy.pay.common.exception.MchMgrException;
import com.cyk.easy.pay.common.utils.IdUtil;
import com.cyk.easy.pay.merchant.domain.merch.model.aggregate.MchAppAggregate;
import com.cyk.easy.pay.merchant.domain.merch.model.entity.IsvInfoEntity;
import com.cyk.easy.pay.merchant.domain.merch.model.entity.MchAppEntity;
import com.cyk.easy.pay.merchant.domain.merch.model.entity.MchInfoEntity;
import com.cyk.easy.pay.merchant.domain.merch.model.entity.SysUserEntity;
import com.cyk.easy.pay.merchant.domain.merch.model.valobj.MchCreateDTO;
import com.cyk.easy.pay.merchant.domain.merch.repository.IIsvInfoRepository;
import com.cyk.easy.pay.merchant.domain.merch.repository.IMchAppRepository;
import com.cyk.easy.pay.merchant.domain.merch.repository.IMchInfoRepository;
import com.cyk.easy.pay.merchant.domain.merch.repository.ISysUserRepository;
import com.cyk.easy.pay.merchant.domain.merch.service.IMchMgrService;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author yukang.chen
 */
@Service
public class IMchMgrServiceImpl implements IMchMgrService {

    @Autowired
    private IMchInfoRepository mchInfoRepository;

    @Autowired
    private IMchAppRepository mchAppRepository;

    @Autowired
    private IIsvInfoRepository isvInfoRepository;

    @Autowired
    private ISysUserRepository sysUserRepository;

    @Autowired
    private MerchantNoGenerator merchantNoGenerator;

    @Autowired
    private RedissonClient redissonClient;

    @Override
    @Transactional
    public void addMch(MchCreateDTO mchInfo, String username) {
        // 1、校验特邀商户信息
        if (Objects.equals(mchInfo.getType(), Constant.MCH_TYPE.MCH_TYPE_ISVSUB) && StringUtils.isNotEmpty(mchInfo.getIsvNo())) {
            IsvInfoEntity isvInfo = isvInfoRepository.getOne(new LambdaQueryWrapper<IsvInfoEntity>().eq(IsvInfoEntity::getIsvNo, mchInfo.getIsvNo()));
            if (isvInfo == null || isvInfo.getState()) {
                throw new MchMgrException("当前服务商不可用");
            }
        }

        String mchNo = merchantNoGenerator.nextMerchantNo(mchInfo.getSourceCode());

        // 2、插入用户信息
        SysUserEntity sysUser = new SysUserEntity();
        sysUser.setUsername(username);
        sysUser.setRealName(mchInfo.getContactName());
        sysUser.setPhoneNumber(mchInfo.getContactTel());
        sysUser.setUserNo(mchNo);
        sysUser.setBelongInfoId(mchNo);
        sysUser.setSex(Constant.SYS_USER.SEX_MALE);
        sysUser.setIsAdmin((byte) 1);
        sysUser.setState((byte) 1);
        sysUser.setSysType("MCH");
        if (!sysUserRepository.save(sysUser)) {
            throw new MchMgrException("创建商户用户失败");
        }

        // 3、插入商户默认应用
        MchAppEntity mchApp = new MchAppEntity();
        mchApp.setAppId(IdUtil.uuid());
        mchApp.setMchNo(mchNo);
        mchApp.setAppName("默认应用");
        mchApp.setAppSecret(RandomUtil.randomString(128));
        mchApp.setState((byte) 1);
        mchApp.setCreatedBy(sysUser.getRealName());
        mchApp.setCreatedUid(sysUser.getSysUserId());
        if (!mchAppRepository.save(mchApp)) {
            throw new MchMgrException("创建商户默认应用失败");
        }

        // 4、插入商户
        MchInfoEntity entity = new MchInfoEntity();
        entity.setMchId(IdUtil.snowflakeId());
        entity.setMchNo(mchNo);
        entity.setMchName(mchInfo.getMchName());
        entity.setMchShortName(mchInfo.getMchShortName());
        entity.setType(mchInfo.getType());
        entity.setIsvNo(mchInfo.getIsvNo());
        entity.setContactName(mchInfo.getContactName());
        entity.setContactTel(mchInfo.getContactTel());
        entity.setState((byte) 1);
        entity.setRemark(mchInfo.getRemark());
        entity.setInitUserId(sysUser.getSysUserId());
        entity.setCreatedBy(sysUser.getRealName());
        entity.setCreatedUid(sysUser.getSysUserId());
        if (!mchInfoRepository.save(entity)) {
            throw new MchMgrException("创建商户失败");
        }
    }

    @Override
    public MchAppAggregate queryMchAndAppInfo(String mchNo, String appId) {
        String key = mchNo + "_" + appId;
        RBucket<MchAppAggregate> bucket = redissonClient.getBucket(RedisKey.MERCHANT_APP_INFO_KEY_PREFIX + key);
        MchAppAggregate aggregate = bucket.get();
        if (aggregate != null) {
            return aggregate;
        }
        RLock lock = redissonClient.getLock(RedisKey.MERCHANT_APP_INFO_LOAD_LOCK_KEY);
        if (lock.tryLock()) {
            try {
                // 再次查询缓存
                aggregate = bucket.get();
                if (aggregate != null) {
                    return aggregate;
                }
                // 查询数据库
                MchInfoEntity mchInfo = mchInfoRepository.getById(mchNo);
                MchAppEntity mchAppInfo = mchAppRepository.getOne(new LambdaQueryWrapper<MchAppEntity>()
                        .eq(MchAppEntity::getMchNo, mchNo)
                        .eq(MchAppEntity::getAppId, appId)
                );
                // 缓存空结果，防止缓存穿透
                if (mchInfo == null || mchAppInfo == null) {
                    bucket.set(null, 60, TimeUnit.SECONDS);
                } else {
                    aggregate = new MchAppAggregate();
                    aggregate.setMchInfo(mchInfo);
                    aggregate.setMchAppInfo(mchAppInfo);
                    // 写入缓存
                    bucket.set(aggregate, 24, TimeUnit.HOURS);
                    return aggregate;
                }
            } finally {
                lock.unlock();
            }
        } else {
            // 获取锁失败，等待缓存刷新（短轮询）
            int retry = 5;
            while (retry-- > 0) {
                try {
                    TimeUnit.MILLISECONDS.sleep(50); // 每 50ms 查询一次缓存
                } catch (InterruptedException e) {
                    throw new MchMgrException("线程中断异常", e);
                }
                aggregate = bucket.get();
                if (aggregate != null) {
                    return aggregate;
                }
            }
        }

        return null;
    }

}
