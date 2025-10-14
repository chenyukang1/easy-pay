package com.cyk.easy.pay.routing.domain;


import com.cyk.easy.pay.routing.domain.channel.model.valobj.TransactionContext;
import com.cyk.easy.pay.routing.domain.rule.model.valobj.RuleMatchResult;

/**
 * @author yukang.chen
 */
public interface IRuleEngineService {

    RuleMatchResult evaluate(TransactionContext ctx);
}
