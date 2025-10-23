package com.cyk.easy.pay.merchant.infrastructure.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyk.easy.pay.merchant.domain.merch.model.entity.MchInfoEntity;
import com.cyk.easy.pay.merchant.domain.merch.repository.IMchInfoRepository;
import com.cyk.easy.pay.merchant.infrastructure.mapper.MchInfoMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商户信息表 服务实现类
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-10-20
 */
@Service
public class MchInfoRepository extends ServiceImpl<MchInfoMapper, MchInfoEntity> implements IMchInfoRepository {

}
