package com.cyk.easy.pay.merchant.api.model;


import lombok.Data;

/**
 * @author yukang.chen
 */
@Data
public class MchInfo {

    /**
     * 商户号
     */
    private String mchNo;

    /**
     * 商户名称
     */
    private String mchName;

    /**
     * 商户简称
     */
    private String mchShortName;

    /**
     * 类型: 1-普通商户, 2-特约商户(服务商模式)
     */
    private Byte type;

    /**
     * 服务商号
     */
    private String isvNo;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人手机号
     */
    private String contactTel;

    /**
     * 联系人邮箱
     */
    private String contactEmail;

    /**
     * 商户状态: 0-停用, 1-正常
     */
    private Byte state;

    /**
     * 商户备注
     */
    private String remark;
}
