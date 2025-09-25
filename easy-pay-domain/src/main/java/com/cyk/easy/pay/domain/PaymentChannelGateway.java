/*
 * Copyright (c) 2015-2025，千寻位置网络有限公司版权所有。
 *
 * 时空智能 共创数字中国（厘米级定位 | 毫米级感知 | 纳秒级授时）
 */
package com.cyk.easy.pay.domain;

import com.cyk.easy.pay.common.valobj.Money;
import com.cyk.easy.pay.domain.channel.model.aggregate.PaymentChannel;
import com.cyk.easy.pay.domain.channel.model.aggregate.PaymentTransaction;

/**
 * @author yukang.chen
 */
public interface PaymentChannelGateway {

    PaymentTransaction createPayment(PaymentChannel channel, String orderId, Money money);

    PaymentTransaction refund(PaymentChannel channel, String orderId, Money money);

    PaymentTransaction query(PaymentChannel channel, String orderId);

}
