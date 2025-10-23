package com.cyk.easy.pay.merchant.interfaces.convert;


/**
 * @author yukang.chen
 */
public interface IConverter<T, R> {

    R convert(T t);
}
