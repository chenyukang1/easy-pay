/*
 * Copyright (c) 2015-2025，千寻位置网络有限公司版权所有。
 *
 * 时空智能 共创数字中国（厘米级定位 | 毫米级感知 | 纳秒级授时）
 */
package com.cyk.easy.pay.domain.channel.model.valobj;

import java.util.Objects;

/**
 * @author yukang.chen
 */
public final class Key {

    private final String privateKey;

    private final String publicKey;

    private final String algorithm;

    public Key(String publicKey, String privateKey, String algorithm) {
        this.publicKey = Objects.requireNonNull(publicKey);
        this.privateKey = Objects.requireNonNull(privateKey);
        this.algorithm = algorithm != null ? algorithm : "RSA";
    }


}
