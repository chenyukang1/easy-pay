package com.cyk.easy.pay.routing.domain.channel.model.aggregate;

import com.cyk.easy.pay.common.valobj.Money;
import com.cyk.easy.pay.routing.domain.PaymentChannelAdapter;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.PaymentQueryRequest;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.PaymentQueryResponse;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.PaymentRequest;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.PaymentResponse;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.RefundRequest;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.RefundResponse;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.FeeRate;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.Limit;
import lombok.Data;

/**
 * 聚合根 支付通道
 *
 * @author yukang.chen
 */
@Data
public final class PaymentChannel {

    /**
     * 渠道代码，例如 "ALIPAY"
     */
    private final String channelCode;

    /**
     * 渠道是否可用
     */
    private boolean status;

    /**
     * 费率
     */
    private FeeRate feeRate;

    /**
     * 限额
     */
    private Limit limit;

    /**
     * 路由权重
     */
    private Integer weight;

    private PaymentChannelAdapter adapter;

    public PaymentChannel(String channelCode, boolean status, FeeRate feeRate, Limit limit, Integer weight,
                          PaymentChannelAdapter adapter) {
        this.channelCode = channelCode;
        this.status = status;
        this.feeRate = feeRate;
        this.limit = limit;
        this.weight = weight;
        this.adapter = adapter;
    }

    public PaymentResponse createPayment(PaymentRequest request) {
        return adapter.createPayment(request);
    }

    public RefundResponse refund(RefundRequest request) {
        return adapter.refund(request);
    }

    public PaymentQueryResponse query(PaymentQueryRequest request) {
        return adapter.query(request);
    }

    // 修改费率
    public void setFeeRate(FeeRate feeRate) {
        if (feeRate == null) {
            throw new IllegalArgumentException("RateConfig cannot be null");
        }
        this.feeRate = feeRate;
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
        return feeRate.calculateFee(amount);
    }

    // 校验限额
    public boolean withinLimit(Money amount) {
        return limit.withinLimit(amount);
    }

    public void disable() {
        this.status = false;
    }

    public void enable() {
        this.status = true;
    }

}
