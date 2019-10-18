package com.cyitce.web.facade.response;

import com.cyitce.web.facade.base.BaseResponse;
import com.cyitce.web.facade.base.Message;

/**
 * @version V1.0
 * @desc: 错误的响应信息
 * @author: k7kit
 * @date: 2019-10-14
 */
class ErrorResponse extends BaseResponse implements Message {

    private String message;

    private int errCode;

    public ErrorResponse() {

    }

    @Override
    public int getCode() {
        return this.errCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Message setMassage(String errMsg) {
        this.message = errMsg;
        return this;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }
}
