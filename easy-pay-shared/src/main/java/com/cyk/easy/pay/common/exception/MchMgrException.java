package com.cyk.easy.pay.common.exception;


import java.io.Serial;

/**
 * @author yukang.chen
 */
public class MchMgrException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -5457778784211530473L;

    public MchMgrException(String message) {
        super(message);
    }

    public MchMgrException(String message, Throwable cause) {
        super(message, cause);
    }
}
