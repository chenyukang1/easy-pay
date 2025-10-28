package com.cyk.easy.pay.gateway.domain.channel.model.valobj.alipay;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yukang.chen
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AlipayIsvSubMchChannelParams {

    private String appAuthToken;
}
