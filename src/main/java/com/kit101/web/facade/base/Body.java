package com.kit101.web.facade.base;

/**
 * @version V1.0
 * @desc: 正确执行时，返回数据
 * @author: k7kit
 * @date: 2019-10-14
 */
public interface Body<T> extends Code {

    Body data(T data);

    T getData();
}
