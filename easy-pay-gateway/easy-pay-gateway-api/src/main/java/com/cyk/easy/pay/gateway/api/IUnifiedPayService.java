package com.cyk.easy.pay.gateway.api;


import com.cyk.easy.pay.gateway.api.model.UnifiedPayReq;
import com.cyk.easy.pay.gateway.api.model.UnifiedPayRes;

/**
 * @author yukang.chen
 */
public interface IUnifiedPayService {

    UnifiedPayRes invoke(UnifiedPayReq req);
}
