package com.cyk.easy.pay.routing.api;


import com.cyk.easy.pay.routing.api.model.RouteStrategy;
import com.cyk.easy.pay.routing.api.model.TradePayRequest;

/**
 * @author yukang.chen
 */
public interface PaymentRoutingService {

    RouteStrategy route(TradePayRequest tradePayRequest);
}
