package com.kit101.web.facade.response;

import com.kit101.web.facade.base.BaseResponse;
import com.kit101.web.facade.base.BaseCode;
import com.kit101.web.facade.exception.BaseException;

/**
 * @version V1.0
 * @desc: 封装返回数据
 * @author: k7kit
 * @date: 2019-10-14
 */
public final class Rest {

    /**
     * @return com.cyitce.web.facade.base.BaseResponse
     * @desc 不需要返回数据，code 0
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
     * @param data 返回数据
     * @return com.cyitce.web.facade.base.BaseResponse
     * @desc data为参数data, code 0
     * @author k7kit
     * @date 2019-10-18
     */
    public static <T> OkResponse ok(T data) {
        return ok(data, 0);
    }

    /**
     * @param data 返回数据
     * @param code 返回码
     * @return com.cyitce.web.facade.base.BaseResponse
     * @desc 返回数据，code 为参数 code
     * @author k7kit
     * @date 2019-10-18
     */
    public static <T> OkResponse ok(T data, Integer code) {
        OkResponse<T> response = new OkResponse<>();
        response.data(data);
        response.setErrCode(code);
        return response;
    }

    /**
     * @param ex 发生的异常
     * @return com.cyitce.web.facade.base.BaseResponse
     * @desc 非正常执行返回信息
     * @author k7kit
     * @date 2019-10-18
     */
    public static ErrorResponse error(Exception ex) {
        if (ex instanceof BaseException) {
            BaseException cex = BaseException.class.cast(ex);
            return error(cex.getCode(), cex.getMessage());
        } else {
            return error(BaseCode.UNKNOWN_ERROR.getCode(), ex.getMessage());
        }
    }


    public static ErrorResponse error(BaseCode error) {
        return error(error.getCode(), error.getMessage());
    }

    /**
     * @param errCode 错误码
     * @param errMsg  错误信息
     * @return com.cyitce.web.facade.base.BaseResponse
     * @desc 非正常执行返回信息
     * @author k7kit
     * @date 2019-10-18
     */
    public static ErrorResponse error(Integer errCode, String errMsg) {
        ErrorResponse response = new ErrorResponse();
        response.message(errMsg);
        response.setErrCode(errCode);
        return response;
    }
}
