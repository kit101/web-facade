package com.kit.web.facade.exception;

import com.kit.web.facade.base.Message;

import java.util.Date;

/**
 * @version V1.0
 * @desc:
 * @author: k7kit
 * @date: 2019-10-14
 */
public class BaseException extends Exception implements Message {

    private Message commonError;

    //直接接收 EmBusinessError 的传参用于构造业务异常
    public BaseException(Message commonError) {
        super();
        this.commonError = commonError;
    }

    //接收自定义 errMsg 的方式构造业务异常（通过覆盖原本errMsg）
    public BaseException(Message commonError, String errMsg) {
        this.commonError = commonError;
        this.commonError.setMassage(errMsg);
    }

    @Override
    public int getCode() {
        return this.commonError.getCode();
    }

    public Date getDate() {
        return new Date();
    }

    public String getRequestId() {
        return null;
    }

    @Override
    public String getMessage() {
        return this.commonError.getMessage();
    }

    @Override
    public Message setMassage(String errMsg) {
        this.commonError.setMassage(errMsg);
        return this;
    }
}


