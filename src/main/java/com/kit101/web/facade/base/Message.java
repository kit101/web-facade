package com.kit101.web.facade.base;

/**
 * @version V1.0
 * @desc: 错误时的错误信息.
 * @author: k7kit
 * @date: 2019-10-14
 */
public interface Message extends Code {

    String getMessage();

    Message message(String errMsg);
}
