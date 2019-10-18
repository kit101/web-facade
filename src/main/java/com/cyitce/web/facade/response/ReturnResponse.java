package com.cyitce.web.facade.response;

import com.cyitce.web.facade.base.BaseResponse;
import com.cyitce.web.facade.base.Body;

/**
 * @version V1.0
 * @desc: 正确的响应信息
 * @author: k7kit
 * @date: 2019-10-14
 */
class ReturnResponse extends BaseResponse implements Body {

    private Object data;

    private int errCode = 0;


    public ReturnResponse() {

    }

    public ReturnResponse(Object o) {
        this.setData(o);
    }

    protected void setErrCode(Integer code) {
        this.errCode = code;
    }

    @Override
    public int getCode() {
        return this.errCode;
    }

    @Override
    public Body setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public Object getData() {
        return this.data;
    }


}
