package com.cyk.easy.pay.gateway.domain.channel.service.pay.alipay;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.cyk.easy.pay.common.utils.DateUtil;
import com.cyk.easy.pay.gateway.domain.channel.model.valobj.PayWay;
import com.cyk.easy.pay.gateway.domain.channel.model.valobj.alipay.AlipayChannelPayReq;
import com.cyk.easy.pay.gateway.domain.channel.model.valobj.alipay.AlipayChannelPayResp;

import static com.cyk.easy.pay.common.constants.Constant.PAY_WAY_CODE;
import static com.cyk.easy.pay.common.utils.DateUtil.DatePattern;

/**
 * @author yukang.chen
 */
@PayWay(PAY_WAY_CODE.ALI_PC)
public class AlipayPC extends AbstractAlipay {

    @Override
    public AlipayChannelPayResp doPay(AlipayChannelPayReq reqModel) throws Exception {
        AlipayTradePagePayRequest req = new AlipayTradePagePayRequest();
        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        model.setOutTradeNo(reqModel.getPayOrderNo());
        model.setSubject(reqModel.getSubject()); //订单标题
        model.setBody(reqModel.getBody()); //订单描述信息
        model.setTotalAmount(reqModel.getMoney().getAmount().toString());  //支付金额
        model.setTimeExpire(DateUtil.format(reqModel.getExpiredTime(), DatePattern.NORM_DATETIME_FORMAT));  // 订单超时时间
        model.setProductCode("FAST_INSTANT_TRADE_PAY");
        model.setQrPayMode("2"); //订单码-跳转模式
        req.setNotifyUrl(getNotifyUrl(reqModel)); // 设置异步通知地址
        req.setReturnUrl(getReturnUrl(reqModel)); // 同步跳转地址
        req.setBizModel(model);

        AlipayClient alipayClient = new DefaultAlipayClient(getAlipayConfig(reqModel));
        AlipayTradePagePayResponse pagePayResponse = alipayClient.pageExecute(req);

        AlipayChannelPayResp resp = new AlipayChannelPayResp();
        resp.setPayUrl(pagePayResponse.getBody());
        resp.setMchOrderNo(reqModel.getMchOrderNo());
        resp.setPayOrderNo(reqModel.getPayOrderNo());
        resp.setOrderState((byte)1); // 支付中
        resp.setPayDataType("");
        resp.setPayData("");
        resp.setErrCode("");
        resp.setErrMsg("");

        return resp;
    }
}
