package com.cyk.easy.pay.gateway.domain.channel.model.valobj.alipay;


import com.cyk.easy.pay.gateway.domain.channel.model.valobj.MchChannelParams;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author yukang.chen
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AlipayMchChannelParams extends MchChannelParams {

    /**
     * 是否沙箱环境
     */
    private Boolean isSandbox;

    /**
     * appId
     */
    private String appId;

    /**
     * privateKey
     */
    private String privateKey;

    /**
     * alipayPublicKey
     */
    private String alipayPublicKey;

    /**
     * 签名方式
     **/
    private String signType;

    /**
     * 是否使用证书方式
     **/
    private Boolean useCert;

    /**
     * app 证书
     **/
    private String appPublicCert;

    /**
     * 支付宝公钥证书（.crt格式）
     **/
    private String alipayPublicCert;

    /**
     * 支付宝根证书
     **/
    private String alipayRootCert;
}
