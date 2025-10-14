package com.cyk.easy.pay.routing.domain.channel.model.valobj;


import lombok.Data;

import java.math.BigDecimal;

/**
 * @author yukang.chen
 */
@Data
public class PaymentChannelDTO {

    /**
     * 商户ID
     */
    private String merchantId;

    /**
     * 应用ID
     */
    private String applicationId;

    /**
     * 渠道ID
     */
    private Long channelId;

    /**
     * 渠道代码  例如： wxpay_jsapi
     */
    private String channelCode;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 启用/禁用
     */
    private Boolean status;

    /**
     * 手续费率
     */
    private BigDecimal feeRate;

    /**
     * 成功率
     */
    private BigDecimal successRate;

    /**
     * 单笔限额
     */
    private BigDecimal limitAmount;

    /**
     * 权重
     */
    private Integer weight;
}
