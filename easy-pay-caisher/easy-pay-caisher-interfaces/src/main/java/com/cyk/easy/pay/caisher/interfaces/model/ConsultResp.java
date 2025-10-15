package com.cyk.easy.pay.caisher.interfaces.model;


import com.cyk.easy.pay.common.valobj.Money;

import java.util.List;

/**
 * @author yukang.chen
 */
public class ConsultResp {

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 咨询ID
     */
    private String consultId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 支付金额
     */
    private Money money;

    /**
     * 推荐支付方式
     */
    private List<RecommendPayWay> recommendPayWays;
}
