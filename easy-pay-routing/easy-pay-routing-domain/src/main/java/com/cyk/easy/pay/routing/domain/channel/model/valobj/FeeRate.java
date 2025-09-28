package com.cyk.easy.pay.routing.domain.channel.model.valobj;

import com.cyk.easy.pay.common.valobj.Money;

/**
 * 值对象 费率
 *
 * @author yukang.chen
 */
public final class FeeRate {

    /**
     * 费率百分比
     */
    private final double rate;

    /**
     * 是否固定费用
     */
    private final boolean fixed;

    public FeeRate(double rate, boolean fixed) {
        if (rate < 0 || rate > 1) {
            throw new IllegalArgumentException("Rate must be between 0 and 1");
        }
        this.rate = rate;
        this.fixed = fixed;
    }

    public Money calculateFee(Money amount) {
        if (fixed) {
            return Money.of(rate, amount.getCurrency()); // 固定金额
        }
        return amount.multiply(rate); // 按比例收取
    }

}
