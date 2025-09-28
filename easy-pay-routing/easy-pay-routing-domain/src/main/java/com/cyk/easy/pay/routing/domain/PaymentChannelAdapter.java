package com.cyk.easy.pay.routing.domain;


import com.cyk.easy.pay.routing.domain.channel.model.valobj.PaymentQueryRequest;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.PaymentQueryResponse;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.PaymentRequest;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.PaymentResponse;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.RefundRequest;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.RefundResponse;

/**
 * @author yukang.chen
 */
public interface PaymentChannelAdapter {

    PaymentResponse createPayment(PaymentRequest request);

    RefundResponse refund(RefundRequest request);

    PaymentQueryResponse query(PaymentQueryRequest request);
}
