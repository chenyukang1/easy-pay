/*
 * Copyright (c) 2015-2025，千寻位置网络有限公司版权所有。
 *
 * 时空智能 共创数字中国（厘米级定位 | 毫米级感知 | 纳秒级授时）
 */
package com.cyk.easy.pay.domain.channel.model.valobj;

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
