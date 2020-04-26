package com.kit101.web.facade.resolver;

import com.kit101.web.facade.base.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @version V1.0
 * @desc:
 * @author: k7kit
 * @date: 2019-10-14
 */
public abstract class BaseController extends com.kit101.web.facade.resolver.ExceptionHandler {

    @ExceptionHandler(Exception.class) //统一处理某一类异常，从而能够减少代码重复率和复杂度
    @ResponseStatus(HttpStatus.OK) //可以将某种异常映射为HTTP状态码
    @ResponseBody
    public BaseResponse handlerException(Exception ex, HttpServletRequest request) {
        return this.handler(ex, request);
    }

}