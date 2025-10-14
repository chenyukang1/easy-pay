package com.cyk.easy.pay.routing.domain;


import com.cyk.easy.pay.routing.domain.channel.model.aggregate.PaymentChannelAggregate;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.TransactionContext;

import java.util.List;

/**
 * @author yukang.chen
 */
public interface IPaymentChannelService {

    List<PaymentChannelAggregate> getAvailableChannels(TransactionContext ctx);
}
