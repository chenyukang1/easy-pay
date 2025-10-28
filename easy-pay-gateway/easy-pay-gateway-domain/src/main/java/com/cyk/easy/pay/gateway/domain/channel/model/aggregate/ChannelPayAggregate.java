package com.cyk.easy.pay.gateway.domain.channel.model.aggregate;


import com.cyk.easy.pay.gateway.domain.channel.model.entity.PayChannelConfigEntity;
import com.cyk.easy.pay.merchant.api.model.MchAppInfo;
import com.cyk.easy.pay.merchant.api.model.MchInfo;
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
public class ChannelPayAggregate {

    private MchInfo mchInfo;

    private MchAppInfo mchAppInfo;

    private PayChannelConfigEntity payChannelConfigEntity;
}
