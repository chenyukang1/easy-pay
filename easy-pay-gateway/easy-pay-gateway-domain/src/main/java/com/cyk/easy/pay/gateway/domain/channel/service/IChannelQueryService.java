package com.cyk.easy.pay.gateway.domain.channel.service;


import com.cyk.easy.pay.gateway.domain.channel.model.valobj.AbstractChannelPayReq;
import com.cyk.easy.pay.gateway.domain.channel.model.valobj.AbstractChannelPayResp;

/**
 * @author yukang.chen
 */
public interface IChannelQueryService<T extends AbstractChannelPayReq, R extends AbstractChannelPayResp> {

    /**
     * 渠道请求
     *
     * @param reqModel 请求参数
     * @return 返回结果
     */
    R pay(T reqModel);
}
