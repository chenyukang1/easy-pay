package com.cyk.easy.pay.gateway.infrastructure.repository;

import com.cyk.easy.pay.gateway.domain.channel.model.entity.PayChannelRateEntity;
import com.cyk.easy.pay.gateway.infrastructure.mapper.PayChannelRateMapper;
import com.cyk.easy.pay.gateway.infrastructure.delete_delete.IPayChannelRateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付通道费率表 服务实现类
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-10-22
 */
@Service
public class PayChannelRateRepository extends ServiceImpl<PayChannelRateMapper, PayChannelRateEntity> implements IPayChannelRateService {

}
