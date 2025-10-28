package com.cyk.easy.pay.gateway.infrastructure.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyk.easy.pay.gateway.domain.channel.model.entity.PayChannelConfigEntity;
import com.cyk.easy.pay.gateway.domain.channel.repository.IPayChannelConfigRepository;
import com.cyk.easy.pay.gateway.infrastructure.mapper.PayChannelConfigMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付通道配置表 服务实现类
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-10-22
 */
@Service
public class PayChannelConfigRepository extends ServiceImpl<PayChannelConfigMapper, PayChannelConfigEntity> implements IPayChannelConfigRepository {

}
