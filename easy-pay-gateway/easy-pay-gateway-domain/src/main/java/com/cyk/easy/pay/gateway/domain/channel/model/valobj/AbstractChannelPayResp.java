package com.cyk.easy.pay.gateway.domain.channel.model.valobj;


import lombok.Data;

/**
 * @author yukang.chen
 */
@Data
public abstract class AbstractChannelPayResp {

    /**
     * 商户订单号
     **/
//    private String mchOrderNo;

    /**
     * 支付订单号
     **/
    private String payOrderNo;

    /**
     * 订单状态
     **/
    private Byte orderState;

    /**
     * 支付参数类型  ( 无参数，  调起支付插件参数， 重定向到指定地址，  用户扫码   )
     **/
    private String payDataType;

    /**
     * 支付参数
     **/
    private String payData;

    /**
     * 渠道返回错误代码
     **/
    private String errCode;

    /**
     * 渠道返回错误信息
     **/
    private String errMsg;

    /**
     * 上游渠道返回数据包 (无需JSON序列化)
     **/
    private ChannelRetMsg channelRetMsg;
}
