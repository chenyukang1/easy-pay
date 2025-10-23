package com.cyk.easy.pay.merchant.interfaces.convert;


import com.cyk.easy.pay.merchant.api.model.MchAndAppInfoResp;
import com.cyk.easy.pay.merchant.api.model.MchAppInfo;
import com.cyk.easy.pay.merchant.api.model.MchInfo;
import com.cyk.easy.pay.merchant.domain.merch.model.aggregate.MchAppAggregate;
import org.springframework.stereotype.Component;

/**
 * @author yukang.chen
 */
@Component
public class MchAppAggregateConverter implements IConverter<MchAppAggregate, MchAndAppInfoResp> {

    @Override
    public MchAndAppInfoResp convert(MchAppAggregate mchAppAggregate) {
        if (mchAppAggregate != null) {
            MchInfo mchInfo = new MchInfo();
            mchInfo.setMchNo(mchAppAggregate.getMchInfo().getMchNo());
            mchInfo.setMchName(mchAppAggregate.getMchInfo().getMchName());
            mchInfo.setMchShortName(mchAppAggregate.getMchInfo().getMchShortName());
            mchInfo.setType(mchAppAggregate.getMchInfo().getType());
            mchInfo.setIsvNo(mchAppAggregate.getMchInfo().getIsvNo());
            mchInfo.setContactName(mchAppAggregate.getMchInfo().getContactName());
            mchInfo.setContactTel(mchAppAggregate.getMchInfo().getContactTel());
            mchInfo.setContactEmail(mchAppAggregate.getMchInfo().getContactEmail());
            mchInfo.setState(mchAppAggregate.getMchInfo().getState());
            mchInfo.setRemark(mchAppAggregate.getMchInfo().getRemark());

            MchAppInfo mchAppInfo = new MchAppInfo();
            mchAppInfo.setAppId(mchAppAggregate.getMchAppInfo().getAppId());
            mchAppInfo.setAppName(mchAppAggregate.getMchAppInfo().getAppName());
            mchAppInfo.setState(mchAppAggregate.getMchAppInfo().getState());
            mchAppInfo.setAppSecret(mchAppAggregate.getMchAppInfo().getAppSecret());
            mchAppInfo.setRemark(mchAppAggregate.getMchAppInfo().getRemark());

            MchAndAppInfoResp resp = new MchAndAppInfoResp();
            resp.setMchInfo(mchInfo);
            resp.setMchAppInfo(mchAppInfo);
            return resp;
        }
        return null;
    }
}
