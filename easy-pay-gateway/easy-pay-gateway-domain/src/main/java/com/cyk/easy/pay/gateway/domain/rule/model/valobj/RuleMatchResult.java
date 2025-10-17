package com.cyk.easy.pay.gateway.domain.rule.model.valobj;

import com.cyk.easy.pay.common.enums.PayMethod;
import lombok.Data;

import java.util.List;

/**
 * @author yukang.chen
 */
@Data
public class RuleMatchResult {

    private List<PayMethod> candidatePayMethods;

    public void addCandidatePayWay(String payWay) {
        this.candidateChannels.add(channelCode);
    }
}
