package com.cyk.easy.pay.routing.api.model;


import com.cyk.easy.pay.common.valobj.Money;

/**
 * @author yukang.chen
 */
public class TradePayRequest {

    private String transactionId;

    private String merchantId;

    private String payWay;

    private Money money;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }
}
