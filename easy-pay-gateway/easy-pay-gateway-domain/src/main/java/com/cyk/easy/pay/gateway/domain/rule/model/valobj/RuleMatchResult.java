package com.cyk.easy.pay.gateway.domain.rule.model.valobj;

import com.cyk.easy.pay.common.enums.PayInterface;
import lombok.Data;

import java.util.List;

/**
 * @author yukang.chen
 */
@Data
public class RuleMatchResult {

    private List<PayInterface> candidatePayInterfaces;

    public void addCandidatePayWay(String payWay) {
//        this.candidateChannels.add(channelCode);
    }
}
