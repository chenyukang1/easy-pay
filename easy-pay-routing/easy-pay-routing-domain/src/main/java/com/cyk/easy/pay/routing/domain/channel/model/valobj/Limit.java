package com.cyk.easy.pay.routing.domain.channel.model.valobj;

import com.cyk.easy.pay.common.valobj.Money;

/**
 * 值对象 限额
 *
 * @author yukang.chen
 */
public final class Limit {

    private final Money perTxLimit;

    private final Money dailyLimit;

    public Limit(Money perTxLimit, Money dailyLimit) {
        if (perTxLimit.lessThan(Money.of(0, perTxLimit.getCurrency()))) {
            throw new IllegalArgumentException("Per transaction limit must be positive");
        }
        this.perTxLimit = perTxLimit;
        this.dailyLimit = dailyLimit;
    }

    public boolean withinLimit(Money amount) {
        return amount.lessThan(perTxLimit) || amount.equals(perTxLimit);
    }

}
