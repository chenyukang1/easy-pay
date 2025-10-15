package com.cyk.easy.pay.common.enums;


/**
 * @author yukang.chen
 */
public enum RespCode {

    ORDER_NOT_FOUND("订单不存在", 10001),
    USER_NOT_FOUND("用户不存在", 10002),
    MERCHANT_NOT_FOUND("商户不存在", 10003),
    USER_INVALID("用户状态异常", 10004),
    MERCHANT_DISABLED("商户停用", 10005),
    NO_AVAILABLE_PAY_WAY("无可用支付方式", 10006),
    INTERNAL_ERROR("系统异常", 20000)
    ;

    private final String msg;

    private final Integer code;

    RespCode(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }
}
