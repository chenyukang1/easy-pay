package com.cyk.easy.pay.routing.domain.channel.model.valobj;

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
