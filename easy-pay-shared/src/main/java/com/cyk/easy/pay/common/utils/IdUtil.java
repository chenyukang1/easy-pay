package com.cyk.easy.pay.common.utils;


/**
 * @author yukang.chen
 */
public class IdUtil {

    private static final UUIDGenerator UUID_GENERATOR = new UUIDGenerator();

    private static final SnowflakeIdGenerator SNOWFLAKE_ID_GENERATOR = new SnowflakeIdGenerator(1, 1);

    public static String uuid() {
        return UUID_GENERATOR.nextId();
    }

    public static Long snowflakeId() {
        return SNOWFLAKE_ID_GENERATOR.nextId();
    }
}
