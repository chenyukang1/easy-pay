package com.cyk.easy.pay.merchant.domain.merch.model.aggregate;


import com.cyk.easy.pay.merchant.domain.merch.model.entity.MchAppEntity;
import com.cyk.easy.pay.merchant.domain.merch.model.entity.MchInfoEntity;
import lombok.Data;

/**
 * @author yukang.chen
 */
@Data
public class MchAppAggregate {

    private MchInfoEntity mchInfo;

    private MchAppEntity mchAppInfo;

}
