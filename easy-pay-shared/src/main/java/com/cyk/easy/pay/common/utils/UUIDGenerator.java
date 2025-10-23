package com.cyk.easy.pay.common.utils;


import java.util.UUID;

/**
 * @author yukang.chen
 */
public class UUIDGenerator implements IdGenerator<String> {

    @Override
    public String nextId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
