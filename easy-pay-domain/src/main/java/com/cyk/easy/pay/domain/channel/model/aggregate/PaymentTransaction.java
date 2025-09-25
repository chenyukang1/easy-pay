/*
 * Copyright (c) 2015-2025，千寻位置网络有限公司版权所有。
 *
 * 时空智能 共创数字中国（厘米级定位 | 毫米级感知 | 纳秒级授时）
 */
package com.cyk.easy.pay.domain.channel.model.aggregate;

/**
 * @author yukang.chen
 */
public final class PaymentTransaction {

    private String transactionId;

    private String orderId;

    private String channelId;

    private String status; // INIT, PROCESSING, SUCCESS, FAILED

    private long amount;

    private String requestData;

    private String responseData;

}
