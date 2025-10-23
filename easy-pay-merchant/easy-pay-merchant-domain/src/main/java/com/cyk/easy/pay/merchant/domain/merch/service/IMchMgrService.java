package com.cyk.easy.pay.merchant.domain.merch.service;


import com.cyk.easy.pay.merchant.domain.merch.model.aggregate.MchAppAggregate;
import com.cyk.easy.pay.merchant.domain.merch.model.valobj.MchCreateDTO;

/**
 * @author yukang.chen
 */
public interface IMchMgrService {

    void addMch(MchCreateDTO entity, String username);

    MchAppAggregate queryMchAndAppInfo(String mchNo, String appId);
}
