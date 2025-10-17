package com.cyk.easy.pay.routing.interfaces.rpc;


import com.cyk.easy.pay.routing.api.PaymentRoutingService;
import com.cyk.easy.pay.routing.api.model.RouteStrategy;
import com.cyk.easy.pay.routing.api.model.TradePayRequest;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author yukang.chen
 */
@DubboService
public class PaymentRoutingServiceImpl implements PaymentRoutingService {
    @Override
    public RouteStrategy route(TradePayRequest tradePayRequest) {
        return null;
    }
}
