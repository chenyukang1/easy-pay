package com.cyk.easy.pay.gateway.domain.channel.service.pay.alipay;


import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayObject;
import com.alipay.api.AlipayRequest;
import com.alipay.api.domain.ExtendParams;
import com.cyk.easy.pay.gateway.domain.channel.model.entity.PayChannelConfigEntity;
import com.cyk.easy.pay.gateway.domain.channel.model.valobj.alipay.AlipayChannelPayReq;
import com.cyk.easy.pay.gateway.domain.channel.model.valobj.alipay.AlipayChannelPayResp;
import com.cyk.easy.pay.gateway.domain.channel.model.valobj.alipay.AlipayIsvChannelParams;
import com.cyk.easy.pay.gateway.domain.channel.model.valobj.alipay.AlipayIsvSubMchChannelParams;
import com.cyk.easy.pay.gateway.domain.channel.repository.IPayChannelConfigRepository;
import com.cyk.easy.pay.gateway.domain.channel.service.pay.AbstractChannelPayService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yukang.chen
 */
public abstract class AbstractAlipay<R extends AlipayRequest, M extends AlipayObject> extends AbstractChannelPayService<AlipayChannelPayReq, AlipayChannelPayResp> {

    @Autowired
    private AliPayClientManager aliPayClientManager;

    @Autowired
    private IPayChannelConfigRepository payChannelConfigRepository;

    protected void putExtParamsIfIsv(AlipayChannelPayReq reqModel, R request, M model) {
        if (!reqModel.getIsvSubMch()) {
            return;
        }
        PayChannelConfigEntity isvChannelConfigEntity = payChannelConfigRepository.queryByConfigId(reqModel.getConfigId());
        PayChannelConfigEntity isvSubChannelConfigEntity = payChannelConfigRepository.queryByConfigId(reqModel.getIsvSubConfigId());
        AlipayIsvChannelParams isvChannelParams = JSON.parseObject(isvChannelConfigEntity.getChannelParams(), AlipayIsvChannelParams.class);
        AlipayIsvSubMchChannelParams isvSubMchChannelParams = JSON.parseObject(isvSubChannelConfigEntity.getChannelParams(), AlipayIsvSubMchChannelParams.class);
        if (isvChannelParams == null || isvSubMchChannelParams == null) {
            throw new IllegalArgumentException("无效的服务商或特约商户支付渠道配置，配置ID：" + reqModel.getConfigId() + "，特约商户配置ID：" + reqModel.getIsvSubConfigId());
        }
        ExtendParams extendParams = new ExtendParams();
        extendParams.setSysServiceProviderId(isvChannelParams.getPid());
        setIsvParams(model, extendParams);
        setIsvSubMchParams(request, isvSubMchChannelParams.getAppAuthToken());
    }

    protected AlipayClient getAlipayClient(Long configId) {
        return aliPayClientManager.getClient(configId);
    }

    protected abstract void setIsvParams(M model, ExtendParams extendParams);

    protected abstract void setIsvSubMchParams(R req, String appAuthToken);
}
