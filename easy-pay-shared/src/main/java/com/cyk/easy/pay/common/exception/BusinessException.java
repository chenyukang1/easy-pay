package com.cyk.easy.pay.common.exception;

/**
 * @author yukang.chen
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -727365829762240284L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
