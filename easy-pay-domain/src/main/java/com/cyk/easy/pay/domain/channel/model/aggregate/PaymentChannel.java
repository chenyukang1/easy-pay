/*
 * Copyright (c) 2015-2025，千寻位置网络有限公司版权所有。
 *
 * 时空智能 共创数字中国（厘米级定位 | 毫米级感知 | 纳秒级授时）
 */
package com.cyk.easy.pay.domain.channel.model.aggregate;

import com.cyk.easy.pay.common.valobj.Money;
import com.cyk.easy.pay.domain.PaymentChannelGateway;
import com.cyk.easy.pay.domain.channel.model.valobj.Limit;
import com.cyk.easy.pay.domain.channel.model.valobj.Rate;
import lombok.Getter;

/**
 * 聚合根 支付通道
 *
 * @author yukang.chen
 */
public final class PaymentChannel {

    @Getter
    private final String channelId; // 渠道ID，例如 "ALIPAY"

    @Getter
    private boolean enabled;

    private Rate rate;

    private Limit limit;

    private PaymentChannelGateway paymentChannelGateway;

    public PaymentChannel(String channelId, Rate rate, Limit limit) {
        this.channelId = channelId;
        this.enabled = true;
        setRate(rate);
        setLimit(limit);
    }

    public PaymentTransaction pay(String orderId, Money money) {
        return paymentChannelGateway.createPayment(this, orderId, money);
    }

    public PaymentTransaction refund(String orderId, Money money) {
        return paymentChannelGateway.refund(this, orderId, money);
    }

    public PaymentTransaction query(String orderId) {
        return paymentChannelGateway.query(this, orderId);
    }

    // 修改费率
    public void setRate(Rate rate) {
        if (rate == null) {
            throw new IllegalArgumentException("RateConfig cannot be null");
        }
        this.rate = rate;
    }

    // 修改限额
    public void setLimit(Limit limit) {
        if (limit == null) {
            throw new IllegalArgumentException("LimitConfig cannot be null");
        }
        this.limit = limit;
    }

    // 计算渠道费用
    public Money calculateFee(Money amount) {
        return rate.calculateFee(amount);
    }

    // 校验限额
    public boolean withinLimit(Money amount) {
        return limit.withinLimit(amount);
    }

    public void disable() {
        this.enabled = false;
    }

    public void enable() {
        this.enabled = true;
    }

}
