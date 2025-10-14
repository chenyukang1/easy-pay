package com.cyk.easy.pay.routing.domain.channel.model.aggregate;

import com.cyk.easy.pay.routing.domain.PaymentChannelAdapter;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.PaymentChannelDTO;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.PaymentQueryRequest;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.PaymentQueryResponse;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.PaymentRequest;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.PaymentResponse;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.RefundRequest;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.RefundResponse;
import lombok.Data;

/**
 * 支付通道聚合根
 *
 * @author yukang.chen
 */
@Data
public final class PaymentChannelAggregate {

    private PaymentChannelDTO dto;

    private PaymentChannelAdapter adapter;

    public PaymentChannelAggregate(PaymentChannelDTO dto, PaymentChannelAdapter adapter) {
        this.dto = dto;
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
}
