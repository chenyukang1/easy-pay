package com.cyk.easy.pay.routing.interfaces.rpc;


import com.cyk.easy.pay.routing.api.PayRoutingService;
import com.cyk.easy.pay.routing.api.model.RouteStrategy;
import com.cyk.easy.pay.routing.api.model.TradePayRequest;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author yukang.chen
 */
@DubboService
public class PayRoutingServiceImpl implements PayRoutingService {
    @Override
    public RouteStrategy route(TradePayRequest tradePayRequest) {
        return null;
    }
}
