package com.cyk.easy.pay.common.exception;


/**
 * @author yukang.chen
 */
public class ChannelNotDeployException extends RuntimeException {

    private static final long serialVersionUID = -3314670932237518929L;

    public ChannelNotDeployException(String message) {
        super(message);
    }

    public ChannelNotDeployException(String message, Throwable cause) {
        super(message, cause);
    }
}
