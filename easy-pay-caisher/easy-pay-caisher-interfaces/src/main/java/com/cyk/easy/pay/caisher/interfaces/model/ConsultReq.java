package com.cyk.easy.pay.caisher.interfaces.model;


import com.cyk.easy.pay.common.enums.PayScene;
import com.cyk.easy.pay.common.valobj.Money;

/**
 * @author yukang.chen
 */
public class ConsultReq {

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 商户ID
     */
    private String merchantId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 支付金额
     */
    private Money money;

    /**
     * 支付场景
     */
    private PayScene scene;

}
