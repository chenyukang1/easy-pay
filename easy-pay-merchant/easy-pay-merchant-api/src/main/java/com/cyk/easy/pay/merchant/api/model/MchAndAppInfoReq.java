package com.cyk.easy.pay.merchant.api.model;


import lombok.Data;

/**
 * @author yukang.chen
 */
@Data
public class MchAndAppInfoReq {

    /**
     * 商户号
     */
    private String mchNo;

    /**
     * 应用ID
     */
    private String appId;
}
