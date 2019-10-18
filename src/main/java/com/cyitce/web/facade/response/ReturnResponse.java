package com.cyitce.web.facade.response;

import com.cyitce.web.facade.base.BaseResponse;
import com.cyitce.web.facade.base.Body;

/**
 * @version V1.0
 * @desc: 正确的响应信息
 * @author: k7kit
 * @date: 2019-10-14
 */
class ReturnResponse<T> extends BaseResponse implements Body<T> {

    private T data;

    private int errCode = 0;


    public ReturnResponse() {
    }

    public ReturnResponse(T data) {
        this.setData(data);
    }

    protected void setErrCode(Integer code) {
        this.errCode = code;
    }

    @Override
    public T getData() {
        return this.data;
    }


    @Override
    public Body setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public int getCode() {
        return this.errCode;
    }

}
