package com.cyk.easy.pay.routing.domain;


import com.cyk.easy.pay.routing.domain.channel.model.aggregate.PaymentChannel;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.TransactionContext;

import java.util.List;

/**
 * @author yukang.chen
 */
public interface IPaymentChannelService {

    List<PaymentChannel> getAvailableChannels(TransactionContext ctx);
}
