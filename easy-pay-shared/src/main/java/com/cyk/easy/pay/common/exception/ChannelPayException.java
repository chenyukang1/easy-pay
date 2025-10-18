package com.cyk.easy.pay.common.exception;


import java.io.Serial;

/**
 * @author yukang.chen
 */
public class ChannelPayException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1948766447371128398L;

    public ChannelPayException(String message) {
        super(message);
    }

    public ChannelPayException(String message, Throwable cause) {
        super(message, cause);
    }
}
