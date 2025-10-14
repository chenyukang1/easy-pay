package com.cyk.easy.pay.routing.infrastructure.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyk.easy.pay.routing.domain.channel.model.entity.PaymentChannelEntity;
import com.cyk.easy.pay.routing.domain.channel.repository.IPaymentChannelRepository;
import com.cyk.easy.pay.routing.infrastructure.mapper.PaymentChannelMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 支付渠道表 服务实现类
 * </p>
 *
 * @author [mybatis plus generator]
 * @since 2025-09-28
 */
@Repository
public class PaymentChannelRepository extends ServiceImpl<PaymentChannelMapper, PaymentChannelEntity> implements IPaymentChannelRepository {

    @Override
    public PaymentChannelEntity getPaymentChannel(String channelId) {
        return null;
    }

    @Override
    public void addPaymentChannel(PaymentChannelEntity entity) {

    }

    @Override
    public void updatePaymentChannel(PaymentChannelEntity entity) {

    }

    @Override
    public void deletePaymentChannel(String channelId) {

    }
}
