package com.cyk.easy.pay.merchant.interfaces.rpc;


import com.cyk.easy.pay.common.constants.R;
import com.cyk.easy.pay.merchant.api.IMchApiService;
import com.cyk.easy.pay.merchant.api.model.MchAndAppInfoReq;
import com.cyk.easy.pay.merchant.api.model.MchAndAppInfoResp;
import com.cyk.easy.pay.merchant.domain.merch.model.aggregate.MchAppAggregate;
import com.cyk.easy.pay.merchant.domain.merch.service.IMchMgrService;
import com.cyk.easy.pay.merchant.interfaces.convert.MchAppAggregateConverter;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yukang.chen
 */
@DubboService
public class MchApiService implements IMchApiService {

    @Autowired
    private IMchMgrService mchMgrService;

    @Autowired
    private MchAppAggregateConverter converter;

    @Override
    public R<MchAndAppInfoResp> queryMchAndAppInfo(MchAndAppInfoReq req) {
        MchAppAggregate aggregate;
        try {
            aggregate = mchMgrService.queryMchAndAppInfo(req.getMchNo(), req.getAppId());
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
        return R.success(converter.convert(aggregate));
    }
}
