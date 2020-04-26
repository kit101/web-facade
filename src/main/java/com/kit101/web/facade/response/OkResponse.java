package com.kit101.web.facade.response;

import com.kit101.web.facade.base.BaseResponse;
import com.kit101.web.facade.base.Body;

/**
 * @version V1.0
 * @desc: 正确的响应信息
 * @author: k7kit
 * @date: 2019-10-14
 */
public class OkResponse<T> extends BaseResponse implements Body<T> {

    private T data;

    private int errCode = 0;


    public OkResponse() {
    }

    public OkResponse(T data) {
        this.data(data);
    }

    protected void setErrCode(Integer code) {
        this.errCode = code;
    }

    @Override
    public T getData() {
        return this.data;
    }


    @Override
    public Body data(T data) {
        this.data = data;
        return this;
    }

    @Override
    public int getCode() {
        return this.errCode;
    }

}
