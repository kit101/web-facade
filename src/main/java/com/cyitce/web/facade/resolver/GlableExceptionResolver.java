package com.cyitce.web.facade.resolver;

import com.cyitce.web.facade.base.BaseResponse;
import com.cyitce.web.facade.exception.BaseException;
import com.cyitce.web.facade.response.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @version V1.0
 * @desc:
 * @author: k7kit
 * @date: 2019-10-17
 */
@ControllerAdvice
@Component
public class GlableExceptionResolver {

    private static Logger logger;

    public GlableExceptionResolver() {
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @ExceptionHandler(Exception.class) //统一处理某一类异常，从而能够减少代码重复率和复杂度
    @ResponseStatus(HttpStatus.OK) //可以将某种异常映射为HTTP状态码
    @ResponseBody
    public BaseResponse handlerException(Exception ex, HttpServletRequest request) {
        BaseResponse re;
        String uri = request.getRequestURI();
        if (ex instanceof BaseException) {
            re = RestResponse.error(ex);
            logger.warn("requestId: {},uri: {},\n {}: {}", re.getRequestId(), uri, ex.getClass().getName(), ex.getMessage());
        } else {
            re = RestResponse.error(ex);
            StackTraceElement s = ex.getStackTrace()[0];
            logger.error("requestId: {},uri: {},\n {}.{}:{}\n {}: {}", re.getRequestId(), uri, s.getClassName(),
                    s.getMethodName(), s.getLineNumber(), ex.getClass().getName(), ex.getMessage());
        }
        return re;
    }
}
