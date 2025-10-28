package com.cyk.easy.pay.merchant.api;


import com.cyk.easy.pay.common.constants.ApiResponse;
import com.cyk.easy.pay.merchant.api.model.MchAndAppInfoReq;
import com.cyk.easy.pay.merchant.api.model.MchAndAppInfoResp;

/**
 * @author yukang.chen
 */
public interface IMchApiService {

    ApiResponse<MchAndAppInfoResp> queryMchAndAppInfo(MchAndAppInfoReq req);
}
