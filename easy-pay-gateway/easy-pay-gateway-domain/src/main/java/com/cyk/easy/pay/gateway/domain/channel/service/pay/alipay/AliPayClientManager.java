package com.cyk.easy.pay.gateway.domain.channel.service.pay.alipay;


import com.alibaba.fastjson2.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConfig;
import com.alipay.api.DefaultAlipayClient;
import com.cyk.easy.pay.common.constants.Constant;
import com.cyk.easy.pay.gateway.domain.channel.model.entity.PayChannelConfigEntity;
import com.cyk.easy.pay.gateway.domain.channel.model.valobj.alipay.AlipayIsvChannelParams;
import com.cyk.easy.pay.gateway.domain.channel.model.valobj.alipay.AlipayMchChannelParams;
import com.cyk.easy.pay.gateway.domain.channel.repository.IPayChannelConfigRepository;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author yukang.chen
 */
@Component
public class AliPayClientManager {

    @Autowired
    private IPayChannelConfigRepository payChannelConfigRepository;

    private final LoadingCache<Long, AlipayClient> clientCache = Caffeine.newBuilder()
            .expireAfterWrite(30, TimeUnit.MINUTES)
            .build(this::loadKey);

    public AlipayClient getClient(Long configId) {
        return clientCache.get(configId);
    }

    @NotNull
    private AlipayClient loadKey(Long configId) throws AlipayApiException {
        PayChannelConfigEntity payChannelConfigEntity = payChannelConfigRepository.queryByConfigId(configId);
        if (payChannelConfigEntity == null) {
            throw new IllegalArgumentException("无效的支付渠道配置ID：" + configId);
        }
        // 普通商户
        if (payChannelConfigEntity.getAccountType() == Constant.MCH_TYPE.MCH_TYPE_NORMAL) {
            AlipayMchChannelParams channelParams = JSON.parseObject(payChannelConfigEntity.getChannelParams(), AlipayMchChannelParams.class);
            return new DefaultAlipayClient(getAlipayConfig(channelParams));
        }
        // 特约商户
        if (payChannelConfigEntity.getAccountType() == Constant.MCH_TYPE.MCH_TYPE_ISVSUB) {
            PayChannelConfigEntity isvChannelConfigEntity = payChannelConfigRepository.queryByIsvNoAndChannelCode(payChannelConfigEntity.getIsvNo(), payChannelConfigEntity.getChannelCode());
            if (isvChannelConfigEntity == null) {
                throw new IllegalArgumentException("无效的服务商支付渠道配置，服务商编号：" + payChannelConfigEntity.getIsvNo() + "，渠道编码：" + payChannelConfigEntity.getChannelCode());
            }
            AlipayIsvChannelParams isvChannelParams = JSON.parseObject(isvChannelConfigEntity.getChannelParams(), AlipayIsvChannelParams.class);
            return new DefaultAlipayClient(getAlipayConfig(isvChannelParams));
        } else {
            throw new IllegalArgumentException("不支持的支付渠道配置类型：" + payChannelConfigEntity.getAccountType());
        }
    }

    @NotNull
    private AlipayConfig getAlipayConfig(AlipayMchChannelParams channelParams) {
        String serverUrl = channelParams.getIsSandbox() ? Constant.AliPay.SANDBOX_SERVER_URL : Constant.AliPay.PROD_SERVER_URL;
        AlipayConfig alipayConfig = new AlipayConfig();
        if (channelParams.getUseCert()) {
            alipayConfig.setServerUrl(serverUrl);
            alipayConfig.setAppId(channelParams.getAppId());
            alipayConfig.setPrivateKey(channelParams.getPrivateKey());
            alipayConfig.setFormat(Constant.AliPay.FORMAT_JSON);
            alipayConfig.setCharset(Constant.AliPay.CHARSET_UTF8);
            alipayConfig.setSignType(channelParams.getSignType());
            // TODO OSS 证书路径处理
//            certAlipayRequest.setCertPath(channelCertConfigKitBean.getCertFilePath(appCert));
//            certAlipayRequest.setAlipayPublicCertPath(channelCertConfigKitBean.getCertFilePath(alipayPublicCert));
//            certAlipayRequest.setRootCertPath(channelCertConfigKitBean.getCertFilePath(alipayRootCert));
        } else {
            alipayConfig.setServerUrl(serverUrl);
            alipayConfig.setAppId(channelParams.getAppId());
            alipayConfig.setFormat(Constant.AliPay.FORMAT_JSON);
            alipayConfig.setCharset(Constant.AliPay.CHARSET_UTF8);
            alipayConfig.setSignType(channelParams.getSignType());
            alipayConfig.setPrivateKey(channelParams.getPrivateKey());
            alipayConfig.setAlipayPublicKey(channelParams.getAlipayPublicKey());
        }
        return alipayConfig;
    }

    private AlipayConfig getAlipayConfig(AlipayIsvChannelParams channelParams) {
        String serverUrl = channelParams.getIsSandbox() ? Constant.AliPay.SANDBOX_SERVER_URL : Constant.AliPay.PROD_SERVER_URL;
        AlipayConfig alipayConfig = new AlipayConfig();
        if (channelParams.getUseCert()) {
            alipayConfig.setServerUrl(serverUrl);
            alipayConfig.setAppId(channelParams.getAppId());
            alipayConfig.setPrivateKey(channelParams.getPrivateKey());
            alipayConfig.setFormat(Constant.AliPay.FORMAT_JSON);
            alipayConfig.setCharset(Constant.AliPay.CHARSET_UTF8);
            alipayConfig.setSignType(channelParams.getSignType());
            // TODO OSS 证书路径处理
//            certAlipayRequest.setCertPath(channelCertConfigKitBean.getCertFilePath(appCert));
//            certAlipayRequest.setAlipayPublicCertPath(channelCertConfigKitBean.getCertFilePath(alipayPublicCert));
//            certAlipayRequest.setRootCertPath(channelCertConfigKitBean.getCertFilePath(alipayRootCert));
        } else {
            alipayConfig.setServerUrl(serverUrl);
            alipayConfig.setAppId(channelParams.getAppId());
            alipayConfig.setFormat(Constant.AliPay.FORMAT_JSON);
            alipayConfig.setCharset(Constant.AliPay.CHARSET_UTF8);
            alipayConfig.setSignType(channelParams.getSignType());
            alipayConfig.setPrivateKey(channelParams.getPrivateKey());
            alipayConfig.setAlipayPublicKey(channelParams.getAlipayPublicKey());
        }
        return alipayConfig;
    }

}
