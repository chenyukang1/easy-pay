package com.cyk.easy.pay.common.utils;


import com.cyk.easy.pay.common.exception.BusinessException;

import java.util.Collection;

/**
 * @author yukang.chen
 */
public class Assert {

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new BusinessException(message);
        }
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new BusinessException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new BusinessException(message);
        }
    }

    public static void notEmpty(String text, String message) {
        if (text == null || text.isEmpty()) {
            throw new BusinessException(message);
        }
    }

    public static void isEmpty(String text, String message) {
        if (text != null && !text.isEmpty()) {
            throw new BusinessException(message);
        }
    }

    public static void notEmpty(Collection<?> collection, String message) {
        if (collection == null || collection.isEmpty()) {
            throw new BusinessException(message);
        }
    }

    public static void isEmpty(Collection<?> collection, String message) {
        if (collection != null && !collection.isEmpty()) {
            throw new BusinessException(message);
        }
    }

}
