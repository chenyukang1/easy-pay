package com.cyk.easy.pay.routing.domain.channel.repository;


import com.cyk.easy.pay.routing.domain.channel.model.aggregate.PaymentChannel;

/**
 * @author yukang.chen
 */
public interface IPaymentChannelRepository {

    PaymentChannel getPaymentChannel(String channelCode);

    void addPaymentChannel(PaymentChannel paymentChannel);

    void updatePaymentChannel(PaymentChannel paymentChannel);

    void deletePaymentChannel(String channelCode);
}
