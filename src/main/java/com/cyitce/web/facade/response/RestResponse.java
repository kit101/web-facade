package com.cyitce.web.facade.response;

import com.cyitce.web.facade.base.BaseResponse;
import com.cyitce.web.facade.base.ResponseCode;
import com.cyitce.web.facade.exception.BaseException;

/**
 * @version V1.0
 * @desc: 封装返回数据
 * @author: k7kit
 * @date: 2019-10-14
 */
public final class RestResponse {

    /**
     * @desc 不需要返回数据，code 0
     * @return com.cyitce.web.facade.base.BaseResponse
     * @author k7kit
     * @date 2019-10-18
     */
    public static BaseResponse ok() {
        return new BaseResponse() {
            @Override
            public int getCode() {
                return 0;
            }
        };
    }

    /**
     * @desc data为参数data,code 0
     * @param data 返回数据
     * @return com.cyitce.web.facade.base.BaseResponse
     * @author k7kit
     * @date 2019-10-18
     */
    public static BaseResponse ok(Object data) {
        return ok(data, 0);
    }

    /**
     * @desc 返回数据，code 为参数 code
     * @param data 返回数据
     * @param code 返回码
     * @return com.cyitce.web.facade.base.BaseResponse
     * @author k7kit
     * @date 2019-10-18
     */
    public static BaseResponse ok(Object data, Integer code) {
        ReturnResponse response = new ReturnResponse();
        response.setData(data);
        response.setErrCode(code);
        return response;
    }

    /**
     * @desc 非正常执行返回信息
     * @param ex 发生的异常
     * @return com.cyitce.web.facade.base.BaseResponse
     * @author k7kit
     * @date 2019-10-18
     */
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

    /**
     * @desc 非正常执行返回信息
     * @param errCode 错误码
     * @param errMsg 错误信息
     * @return com.cyitce.web.facade.base.BaseResponse
     * @author k7kit
     * @date 2019-10-18
     */
    public static BaseResponse error(Integer errCode, String errMsg) {
        ErrorResponse response = new ErrorResponse();
        response.setMassage(errMsg);
        response.setErrCode(errCode);
        return response;
    }
}
