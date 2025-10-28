package com.cyk.easy.pay.gateway.domain.channel.service.pay;


import com.cyk.easy.pay.common.constants.ApiResponse;
import com.cyk.easy.pay.common.exception.ChannelPayException;
import com.cyk.easy.pay.gateway.domain.channel.model.annotation.PayWay;
import com.cyk.easy.pay.gateway.domain.channel.model.valobj.AbstractChannelPayReq;
import com.cyk.easy.pay.gateway.domain.channel.model.valobj.AbstractChannelPayResp;
import com.cyk.easy.pay.gateway.domain.channel.service.IChannelPayService;
import com.cyk.easy.pay.merchant.api.IMchApiService;
import com.cyk.easy.pay.merchant.api.model.MchAndAppInfoReq;
import com.cyk.easy.pay.merchant.api.model.MchAndAppInfoResp;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.codehaus.plexus.util.StringUtils;

/**
 * @author yukang.chen
 */
@Slf4j
public abstract class AbstractChannelPayService<T extends AbstractChannelPayReq, R extends AbstractChannelPayResp>
        implements IChannelPayService<T, R> {

    @DubboReference
    private IMchApiService mchApiService;

    @Override
    public R pay(T reqModel) {
        try {
            if (reqModel.getIsvSubMch() && StringUtils.isBlank(reqModel.getIsvNo())) {
                throw new ChannelPayException("特约商户支付时，服务商号不能为空");
            }
            MchAndAppInfoReq mchAndAppInfoReq = new MchAndAppInfoReq();
            mchAndAppInfoReq.setMchNo(reqModel.getMchNo());
            mchAndAppInfoReq.setAppId(reqModel.getAppId());
            ApiResponse<MchAndAppInfoResp> apiResponse = mchApiService.queryMchAndAppInfo(mchAndAppInfoReq);
            if (!apiResponse.isSuccess()) {
                throw new ChannelPayException("查询商户应用信息失败：" + apiResponse.getMessage());
            }
            MchAndAppInfoResp mchAndAppInfoResp = apiResponse.getData();
            if (mchAndAppInfoResp == null) {
                throw new ChannelPayException("查询商户应用信息失败：返回结果为空");
            }
            if (mchAndAppInfoResp.getMchInfo() == null) {
                throw new ChannelPayException("查询商户信息失败：返回结果为空");
            }
            if (mchAndAppInfoResp.getMchAppInfo() == null) {
                throw new ChannelPayException("查询商户信息失败：返回结果为空");
            }

            return doPay(reqModel);
        } catch (Exception e) {
            log.error("{} 渠道支付异常：", reqModel.getWayCode(), e);
            throw new ChannelPayException("渠道支付异常：" + e.getMessage());
        }
    }

    public String getNotifyUrl(T reqModel) {
        return "/api/pay/notify/" + getIfCode();
    }

    public String getReturnUrl(T reqModel) {
        return "/api/pay/return/" + getIfCode();
    }

    private String getIfCode() {
        PayWay payWay = this.getClass().getAnnotation(PayWay.class);
        if (payWay == null) {
            throw new ChannelPayException("渠道支付类缺少PayWay注解：" + this.getClass().getName());
        }
        return payWay.value();
    }

    protected abstract R doPay(T reqModel) throws Exception;

}
