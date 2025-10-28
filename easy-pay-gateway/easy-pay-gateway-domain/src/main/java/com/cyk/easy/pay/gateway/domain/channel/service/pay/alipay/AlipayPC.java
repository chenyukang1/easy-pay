package com.cyk.easy.pay.gateway.domain.channel.service.pay.alipay;

import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.domain.ExtendParams;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.cyk.easy.pay.common.utils.DateUtil;
import com.cyk.easy.pay.gateway.domain.channel.model.annotation.PayWay;
import com.cyk.easy.pay.gateway.domain.channel.model.valobj.ChannelRetMsg;
import com.cyk.easy.pay.gateway.domain.channel.model.valobj.alipay.AlipayChannelPayReq;
import com.cyk.easy.pay.gateway.domain.channel.model.valobj.alipay.AlipayChannelPayResp;
import org.springframework.stereotype.Component;

import static com.cyk.easy.pay.common.constants.Constant.PAY_WAY_CODE;
import static com.cyk.easy.pay.common.utils.DateUtil.DatePattern;

/**
 * @author yukang.chen
 */
@PayWay(PAY_WAY_CODE.ALI_PC)
@Component
public class AlipayPC extends AbstractAlipay<AlipayTradePagePayRequest, AlipayTradePagePayModel> {

    @Override
    public AlipayChannelPayResp doPay(AlipayChannelPayReq reqModel) throws Exception {
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        model.setOutTradeNo(reqModel.getPayOrderNo());
        model.setSubject(reqModel.getSubject()); //订单标题
        model.setBody(reqModel.getBody()); //订单描述信息
        model.setTotalAmount(reqModel.getMoney().getAmount().toString());  //支付金额
        model.setTimeExpire(DateUtil.format(reqModel.getExpiredTime(), DatePattern.NORM_DATETIME_FORMAT));  // 订单超时时间
        model.setProductCode("FAST_INSTANT_TRADE_PAY");
        model.setQrPayMode("2"); //订单码-跳转模式
        request.setNotifyUrl(getNotifyUrl(reqModel)); // 设置异步通知地址
        request.setReturnUrl(getReturnUrl(reqModel)); // 同步跳转地址
        request.setBizModel(model);

        // 特约商户支付，设置服务商参数
        putExtParamsIfIsv(reqModel, request, model);
        AlipayTradePagePayResponse pagePayResponse = getAlipayClient(reqModel.getConfigId()).pageExecute(request);

        ChannelRetMsg channelRetMsg = new ChannelRetMsg();
        channelRetMsg.setChannelState(ChannelRetMsg.ChannelState.WAITING);
        AlipayChannelPayResp resp = new AlipayChannelPayResp();
        resp.setPayUrl(pagePayResponse.getBody());
        resp.setPayOrderNo(reqModel.getPayOrderNo());
        resp.setOrderState((byte)1); // 支付中
        resp.setChannelRetMsg(channelRetMsg);

        return resp;
    }

    @Override
    protected void setIsvParams(AlipayTradePagePayModel model, ExtendParams extendParams) {
        model.setExtendParams(extendParams);
    }

    @Override
    protected void setIsvSubMchParams(AlipayTradePagePayRequest req, String appAuthToken) {
        req.putOtherTextParam("app_auth_token", appAuthToken);
    }
}
