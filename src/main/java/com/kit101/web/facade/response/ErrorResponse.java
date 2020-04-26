package com.kit101.web.facade.response;

import com.kit101.web.facade.base.BaseResponse;
import com.kit101.web.facade.base.Message;
import org.springframework.http.HttpStatus;

/**
 * @version V1.0
 * @desc: 错误的响应信息
 * @author: k7kit
 * @date: 2019-10-14
 */
public class ErrorResponse extends BaseResponse implements Message {

    private String message;

    private int errCode;

    private int httpStatus = 200;


    @Override
    public int getCode() {
        return this.errCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Message message(String errMsg) {
        this.message = errMsg;
        return this;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }


    public int httpStatusCode() {
        return httpStatus;
    }

    public HttpStatus httpStatus() {
        return HttpStatus.resolve(this.httpStatus);
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus.value();
    }


    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }
}
