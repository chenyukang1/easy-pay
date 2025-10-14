package com.cyk.easy.pay.routing.domain.rule.model.valobj;

import com.cyk.easy.pay.common.enums.PayWay;
import lombok.Data;

import java.util.List;

/**
 * @author yukang.chen
 */
@Data
public class RuleMatchResult {

    private List<PayWay> candidatePayWays;

    public void addCandidatePayWay(String payWay) {
        this.candidateChannels.add(channelCode);
    }
}
