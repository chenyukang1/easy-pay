package com.cyk.easy.pay.routing.domain.channel.repository;

import com.cyk.easy.pay.routing.domain.channel.model.entity.PaymentChannelEntity;

import java.util.List;

/**
 * @author yukang.chen
 */
public interface IPaymentChannelRepository {

    PaymentChannelEntity getPaymentChannel(Long channelId);

    List<PaymentChannelEntity> getPaymentChannels(List<Long> channelIds);

    void addPaymentChannel(PaymentChannelEntity entity);

    void updatePaymentChannel(PaymentChannelEntity entity);

    void deletePaymentChannel(Long channelId);
}
