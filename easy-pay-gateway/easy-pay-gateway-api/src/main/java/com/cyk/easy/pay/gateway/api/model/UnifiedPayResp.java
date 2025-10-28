package com.cyk.easy.pay.gateway.api.model;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author yukang.chen
 */
@Data
public class UnifiedPayResp implements Serializable {

    @Serial
    private static final long serialVersionUID = 703932154444509814L;

    /**
     * 支付订单号
     **/
    private String payOrderNo;

    /**
     * 支付方式  如： wxpay_jsapi,alipay_wap等
     **/
    private String wayCode;

    /**
     * 支付接口  如： wxpay,alipay等
     **/
    private String ifCode;

    /**
     * 第三方支付平台生成的订单号（如微信支付订单号）
     */
    private String channelOrderNo;

    /**
     * 支付数据类型  ( 无参数，  调起支付插件参数， 重定向到指定地址，  用户扫码   )
     * CODE_URL、FORM_HTML、APP_PARAMS、JSAPI_PARAMS
     **/
    private String payDataType;

    /**
     * 支付核心数据（二维码地址、HTML表单、调起参数JSON）
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
     * 渠道返回数据包 (无需JSON序列化)
     **/
    @JSONField(serialize = false)
    private ChannelRetMsg channelRetMsg;
}
