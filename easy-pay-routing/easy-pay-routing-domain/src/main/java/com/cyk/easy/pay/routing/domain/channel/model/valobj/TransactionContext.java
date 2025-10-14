package com.cyk.easy.pay.routing.domain.channel.model.valobj;


import com.cyk.easy.pay.common.enums.PayWay;
import com.cyk.easy.pay.common.enums.PayScene;
import com.cyk.easy.pay.common.valobj.Money;
import lombok.Data;

/**
 * @author yukang.chen
 */
@Data
public class TransactionContext {

    /**
     * 交易id
     */
    private String transactionId;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 商户信息
     */
    private MerchantInfo merchantInfo;

    /**
     * 金额
     */
    private Money money;

    /**
     * 支付场景 APP/H5/扫码
     */
    private PayScene scene;

    /**
     * 支付方式 微信支付/支付宝/银联
     */
    private PayWay method;

}
