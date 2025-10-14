package com.cyk.easy.pay.routing.domain.channel.repository;

import com.cyk.easy.pay.routing.domain.channel.model.entity.MerchantPaymentChannelEntity;

import java.util.List;

/**
 * @author yukang.chen
 */
public interface IMerchantPaymentChannelRepository {

    /**
     * 获取商户配置的可用通道
     *
     * @param merchantId    the merchant id
     * @param applicationId the application id
     * @return the available channels by merchant application id
     */
    List<MerchantPaymentChannelEntity> getAvailableChannelsByMerchantApplicationId(String merchantId,
                                                                                   String applicationId);
}
