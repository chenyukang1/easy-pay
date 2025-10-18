package com.cyk.easy.pay.gateway.api;


import com.cyk.easy.pay.gateway.api.model.UnifiedPayReq;
import com.cyk.easy.pay.gateway.api.model.UnifiedPayResp;

/**
 * @author yukang.chen
 */
public interface IUnifiedPayService {

    UnifiedPayResp invoke(UnifiedPayReq req);
}
