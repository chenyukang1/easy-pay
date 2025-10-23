package com.cyk.easy.pay.merchant.api.model;


import lombok.Data;

/**
 * @author yukang.chen
 */
@Data
public class MchAppInfo {

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 应用状态: 0-停用, 1-正常
     */
    private Byte state;

    /**
     * 应用私钥
     */
    private String appSecret;

    /**
     * 备注
     */
    private String remark;
}
