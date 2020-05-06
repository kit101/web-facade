package com.kit101.web.facade.resolver;

import com.kit101.web.facade.base.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @version V1.0
 * @desc: 注入到Spring bean，即可开启全局异常处理.
 * @author: k7kit
 * @date: 2019-10-17
 */
@RestControllerAdvice
public class GlobalExceptionResolver extends com.kit101.web.facade.resolver.ExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    public GlobalExceptionResolver() {
        logger.debug("enabled {}.", this.getClass().getName());
    }

    /**
     * 全局异常处理
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class) //统一处理某一类异常，从而能够减少代码重复率和复杂度
    @ResponseStatus(HttpStatus.OK) //可以将某种异常映射为HTTP状态码
    @ResponseBody
    public BaseResponse handlerException(Exception ex, HttpServletRequest request) {
        return this.handler(ex, request);
    }
}
