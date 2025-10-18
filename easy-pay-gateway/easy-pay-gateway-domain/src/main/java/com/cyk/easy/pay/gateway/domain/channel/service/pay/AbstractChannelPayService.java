package com.cyk.easy.pay.gateway.domain.channel.service.pay;


import com.cyk.easy.pay.common.exception.ChannelPayException;
import com.cyk.easy.pay.gateway.domain.channel.model.valobj.AbstractChannelPayReq;
import com.cyk.easy.pay.gateway.domain.channel.model.valobj.AbstractChannelPayResp;
import com.cyk.easy.pay.gateway.domain.channel.model.valobj.PayWay;
import com.cyk.easy.pay.gateway.domain.channel.service.IChannelPayService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author yukang.chen
 */
@Slf4j
public abstract class AbstractChannelPayService<T extends AbstractChannelPayReq, R extends AbstractChannelPayResp>
        implements IChannelPayService<T, R> {

    @Override
    public R pay(T reqModel) {
        try {
            return doPay(reqModel);
        } catch (Exception e) {
            log.error("{} 渠道支付异常：", reqModel.getWayCode(), e);
            throw new ChannelPayException("渠道支付异常：" + e.getMessage());
        }
    }

    public String getNotifyUrl(T reqModel) {
        if (StringUtils.isNotEmpty(reqModel.getNotifyUrl())) {
            return reqModel.getNotifyUrl();
        }
        return "/api/pay/notify/" + getIfCode();
    }

    public String getReturnUrl(T reqModel) {
        if (StringUtils.isNotEmpty(reqModel.getReturnUrl())) {
            return reqModel.getNotifyUrl();
        }
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
