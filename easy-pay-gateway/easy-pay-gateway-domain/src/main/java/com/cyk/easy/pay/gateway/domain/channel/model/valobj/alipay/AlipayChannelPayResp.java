package com.cyk.easy.pay.gateway.domain.channel.model.valobj.alipay;


import com.cyk.easy.pay.gateway.domain.channel.model.valobj.AbstractChannelPayResp;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yukang.chen
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AlipayChannelPayResp extends AbstractChannelPayResp {


    /** 跳转地址 **/
    private String payUrl;

    /** 二维码地址 **/
    private String codeUrl;

    /** 二维码图片地址 **/
    private String codeImgUrl;

    /** 表单内容 **/
    private String formContent;
}
