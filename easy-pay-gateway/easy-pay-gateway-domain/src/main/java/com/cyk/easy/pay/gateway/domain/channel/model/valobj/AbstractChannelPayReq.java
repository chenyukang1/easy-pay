package com.cyk.easy.pay.gateway.domain.channel.model.valobj;


import com.cyk.easy.pay.common.valobj.Money;
import lombok.Data;

/**
 * @author yukang.chen
 */
@Data
public abstract class AbstractChannelPayReq {

    /**
     * 商户号
     **/
    private String mchNo;

    /**
     * 商户应用ID
     **/
    private String appId;

    /**
     * 是否特约商户
     **/
    private Boolean isvSubMch;

    /**
     * 特约商户支付渠道配置ID
     **/
    private Long isvSubConfigId;

    /**
     * 渠道配置ID
     **/
    private Long configId;

    /**
     * 支付订单号
     **/
    private String payOrderNo;

    /**
     * 支付方式  如： wxpay_jsapi,alipay_wap等
     **/
    private String wayCode;

    /**
     * 金额
     **/
    private Money money;

    /**
     * 商品标题
     **/
    private String subject;

    /**
     * 商品描述信息
     **/
    private String body;

    /**
     * 订单失效时间, 单位：秒
     **/
    private Long expiredTime;

    /**
     * 特定渠道发起额外参数
     **/
    private String channelExtra;

    /**
     * 商户扩展参数
     **/
    private String extParam;

    /**
     * 分账模式： 0-该笔订单不允许分账, 1-支付成功按配置自动完成分账, 2-商户手动分账(解冻商户金额)
     **/
    private Byte divisionMode;

}
