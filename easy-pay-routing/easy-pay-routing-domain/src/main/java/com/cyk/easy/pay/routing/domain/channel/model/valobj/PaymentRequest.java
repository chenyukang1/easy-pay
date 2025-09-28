package com.cyk.easy.pay.routing.domain.channel.model.valobj;


import com.cyk.easy.pay.common.valobj.Money;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yukang.chen
 */
@Data
public class PaymentRequest implements Serializable {

    private static final long serialVersionUID = -9203295666831125504L;

    /**
     * 版本号
     **/
    protected String version;

    /**
     * 签名类型
     **/
    protected String signType;

    /**
     * 签名值
     **/
    protected String sign;

    /**
     * 接口请求时间
     **/
    protected String reqTime;

    /**
     * 商户订单号
     **/
    private String mchOrderNo;

    /**
     * 支付方式  如： wxpay_jsapi,alipay_wap等
     **/
    private String channelCode;

    /**
     * 支付金额， 单位：分
     **/
    private Money money;

    /**
     * 客户端IP地址
     **/
    private String clientIp;

    /**
     * 商品标题
     **/
    private String subject;

    /**
     * 商品描述信息
     **/
    private String body;

    /**
     * 异步通知地址
     **/
    private String notifyUrl;

    /**
     * 跳转通知地址
     **/
    private String returnUrl;

    /**
     * 订单失效时间, 单位：秒
     **/
    private Integer expiredTime;

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
