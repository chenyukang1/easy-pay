package com.cyk.easy.pay.common.enums;


import lombok.Getter;

/**
 * 服务类别
 *
 * @author yukang.chen
 */
@Getter
public enum ServiceType {

    //扫码支付
    SCAN_CODE("scan_code"),

    //APP支付
    APP("app"),

    //付款码支付
    BRUSH_CARD("brush_card"),

    //公众号支付
    GZ("gz"),

    //小程序支付
    MINI_PROGRAM("mini_program"),

    //手机网站支付
    MOBILE_H5("mobile_h5"),

    //电脑网站支付
    PC_WEB("pc_web"),

    //支付查询
    PAY_QUERY("pay_query"),

    //退款查询
    REFUND_QUERY("refund_query"),

    //支付通知
    PAY_NOTIFY("pay_notify");

    private final String code;

    ServiceType(String code) {
        this.code = code;
    }
}
