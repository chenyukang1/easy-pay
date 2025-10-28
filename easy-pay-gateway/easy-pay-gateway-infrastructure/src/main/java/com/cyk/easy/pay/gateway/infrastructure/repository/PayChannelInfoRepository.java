package com.cyk.easy.pay.gateway.infrastructure.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyk.easy.pay.gateway.domain.channel.model.entity.PayChannelInfoEntity;
import com.cyk.easy.pay.gateway.domain.channel.repository.IPayChannelInfoRepository;
import com.cyk.easy.pay.gateway.infrastructure.mapper.PayChannelInfoMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付通道定义表 服务实现类
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-10-22
 */
@Service
public class PayChannelInfoRepository extends ServiceImpl<PayChannelInfoMapper, PayChannelInfoEntity> implements IPayChannelInfoRepository {

}
