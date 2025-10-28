package com.cyk.easy.pay.gateway.api.model;


import com.cyk.easy.pay.common.valobj.Money;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serial;

/**
 * @author yukang.chen
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UnifiedPayReq extends AbstractPayReq {

    @Serial
    private static final long serialVersionUID = -9223239991852312175L;

    /**
     * 商户号
     **/
    @NotBlank(message = "商户号不能为空")
    private String merchantId;

    /**
     * 应用号
     **/
    @NotBlank(message = "应用号不能为空")
    private String applicationId;

    /**
     * 支付订单号
     **/
    @NotBlank(message = "支付订单号不能为空")
    private String payOrderNo;

    /**
     * 支付方式  如： wxpay_jsapi,alipay_wap等
     **/
    @NotNull(message = "支付方式不能为空")
    private String wayCode;

    /**
     * 支付接口  如： wxpay,alipay等
     **/
    @NotNull(message = "支付方式不能为空")
    private String ifCode;

    /**
     * 金额
     **/
    @NotNull(message = "金额不能为空")
    private Money money;

    /**
     * 商品标题
     **/
    @NotBlank(message = "商品标题不能为空")
    private String subject;

    /**
     * 商品描述信息
     **/
    @NotBlank(message = "商品描述信息不能为空")
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
    @Range(min = 0, max = 2, message = "分账模式设置值有误")
    private Byte divisionMode;
}
