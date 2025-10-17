package com.cyk.easy.pay.gateway.domain.rule.service;


import com.cyk.easy.pay.common.exception.ChannelNotDeployException;
import com.cyk.easy.pay.common.utils.Assert;
import com.cyk.easy.pay.routing.domain.IRuleEngineService;
import com.cyk.easy.pay.routing.domain.channel.model.entity.MerchantPaymentChannelEntity;
import com.cyk.easy.pay.routing.domain.channel.model.entity.PaymentChannelEntity;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.PaymentChannelDTO;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.TransactionContext;
import com.cyk.easy.pay.routing.domain.channel.repository.IMerchantPaymentChannelRepository;
import com.cyk.easy.pay.routing.domain.channel.repository.IPaymentChannelRepository;
import com.cyk.easy.pay.routing.domain.rule.model.valobj.RuleMatchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author yukang.chen
 */
@Service
public class DroolsRuleEngineService implements IRuleEngineService {

    @Autowired
    private IMerchantPaymentChannelRepository merchantPaymentChannelRepository;

    @Autowired
    private IPaymentChannelRepository paymentChannelRepository;

    @Override
    public RuleMatchResult evaluate(TransactionContext ctx) {
        Assert.notEmpty(ctx.getTransactionId(), "transactionId不能为空");
        Assert.notEmpty(ctx.getOrderId(), "orderId不能为空");
        Assert.notEmpty(ctx.getMerchantId(), "merchantId不能为空");
        Assert.notEmpty(ctx.getApplicationId(), "applicationId不能为空");
        Assert.notNull(ctx.getMoney(), "money不能为空");
        Assert.notNull(ctx.getScene(), "scene不能为空");
        Assert.notNull(ctx.getMethod(), "method不能为空");

        // 1. 查询商户配置的支付渠道
        List<MerchantPaymentChannelEntity> entities =
                merchantPaymentChannelRepository.getAvailableChannelsByMerchantApplicationId(ctx.getMerchantId(),
                        ctx.getApplicationId());
        if (entities == null || entities.isEmpty()) {
            throw new ChannelNotDeployException("商户未配置支付渠道");
        }
        for (MerchantPaymentChannelEntity entity : entities) {
            if (!entity.getStatus()) {
                throw new ChannelNotDeployException("商户支付渠道不可用");
            }
        }
        List<Long> channelIds = entities.stream().map(MerchantPaymentChannelEntity::getChannelId).collect(Collectors.toList());
        List<PaymentChannelEntity> paymentChannels = paymentChannelRepository.getPaymentChannels(channelIds);
        List<PaymentChannelDTO> dtos = new ArrayList<>();
        for (int i = 0; i < entities.size(); i++) {
            if (!Optional.ofNullable(paymentChannels.get(i).getStatus()).orElse(false)) {
                continue;
            }
            dtos.add(entities.get(i).toPaymentChannelDTO(paymentChannels.get(i)));
        }

        return null;
    }

}
