package com.cyitce.web.facade.base;

/**
 * @version V1.0
 * @desc:
 * @author: k7kit
 * @date: 2019-10-14
 */
public interface Message extends Code {

    String getMessage();

    Message setMassage(String errMsg);
}
