package com.cyitce.web.facade.response;

import com.cyitce.web.facade.base.BaseResponse;
import com.cyitce.web.facade.base.ResponseCode;
import com.cyitce.web.facade.exception.BaseException;

/**
 * @version V1.0
 * @desc:
 * @author: k7kit
 * @date: 2019-10-14
 */
public class RestResponse {

    public static BaseResponse ok() {
        return new BaseResponse() {
            @Override
            public int getCode() {
                return 0;
            }
        };
    }

    public static BaseResponse ok(Object data) {
        return ok(data, 0);
    }

    public static BaseResponse ok(Object data, Integer code) {
        ReturnResponse response = new ReturnResponse();
        response.setData(data);
        response.setErrCode(code);
        return response;
    }

    public static BaseResponse error(Exception ex) {
        if (ex instanceof BaseException) {
            BaseException cex = BaseException.class.cast(ex);
            return error(cex.getCode(), cex.getMessage());
        } else {
            return error(ResponseCode.UNKNOW_ERROR.getCode(), ex.getMessage());
        }
    }

    public static BaseResponse error(ResponseCode error) {
        return error(error.getCode(), error.getMessage());
    }

    public static BaseResponse error(Integer errCode, String errMsg) {
        ErrorResponse response = new ErrorResponse();
        response.setMassage(errMsg);
        response.setErrCode(errCode);
        return response;
    }
}
