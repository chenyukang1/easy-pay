package com.cyk.easy.pay.merchant.domain.merch.service.mgr;


import com.cyk.easy.pay.common.constants.RedisKey;
import com.cyk.easy.pay.common.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author yukang.chen
 */
@Component
public class MerchantNoGenerator {

    @Autowired
    private RedissonClient redissonClient;

    private static final String PREFIX = "M";              // 前缀
    private static final int SC_LEN = 4;                // 来源标识，填充0
    private static final int SEQ_LEN = 6;                // 序列长度，填充0

    /**
     * Next merchant no string.
     * <br/>
     * 前缀1位 + 来源4位 + 日期8位(yyyyMMdd) + 序列6位（每天从000001开始）
     *
     * @param sourceCode the source code
     * @return the string
     */
    public String nextMerchantNo(String sourceCode) {
        if (sourceCode == null || StringUtils.isBlank(sourceCode)) {
            throw new IllegalArgumentException("sourceCode must not blank");
        }
        if (sourceCode.length() >= SC_LEN) {
            sourceCode = sourceCode.substring(0, SC_LEN);
        } else {
            sourceCode = StringUtils.leftPad(sourceCode, SC_LEN, '0');
        }
        String date = DateUtil.format(System.currentTimeMillis(), DateUtil.DatePattern.DAY_DATETIME_FORMAT);

        RAtomicLong atomicLong = redissonClient.getAtomicLong(RedisKey.MERCHANT_NO_PREFIX + sourceCode + "_" + date);
        long seq = atomicLong.incrementAndGet();
        if (seq == 1L) {
            atomicLong.expire(3, TimeUnit.DAYS);
        }
        String seqStr = StringUtils.leftPad(String.valueOf(seq), SEQ_LEN, '0');

        return PREFIX + sourceCode + date + seqStr;
    }
}
