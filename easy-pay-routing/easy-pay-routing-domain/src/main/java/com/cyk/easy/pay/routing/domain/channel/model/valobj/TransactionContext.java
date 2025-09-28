package com.cyk.easy.pay.routing.domain.channel.model.valobj;


/**
 * @author yukang.chen
 */
public class TransactionContext {

    private String transactionId;

    private String orderId;

    private String channelId;

    private String status; // INIT, PROCESSING, SUCCESS, FAILED

    private long amount;

    private String requestData;

    private String responseData;
}
