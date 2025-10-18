package com.cyk.easy.pay.gateway.domain.channel.service.pay.alipay;


import com.alipay.api.AlipayConfig;
import com.cyk.easy.pay.gateway.domain.channel.model.valobj.alipay.AlipayChannelPayReq;
import com.cyk.easy.pay.gateway.domain.channel.model.valobj.alipay.AlipayChannelPayResp;
import com.cyk.easy.pay.gateway.domain.channel.service.pay.AbstractChannelPayService;

/**
 * @author yukang.chen
 */
public abstract class AbstractAlipay extends AbstractChannelPayService<AlipayChannelPayReq, AlipayChannelPayResp> {

    public AlipayConfig getAlipayConfig(AlipayChannelPayReq req) {
        return null;
    }
}
