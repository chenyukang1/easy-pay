package com.cyk.easy.pay.routing.domain.channel.model.valobj;


import lombok.Data;

import java.util.List;

/**
 * @author yukang.chen
 */
@Data
public class MerchantInfo {

    /**
     * 商户id
     */
    private String merchantId;

    /**
     * 商户应用id
     */
    private String applicationId;

    /**
     * 商户支持的支付方式
     */
    private List<String> payWayList;
}
