package com.kit101.web.facade.resolver;

import com.kit101.web.facade.base.BaseResponse;
import com.kit101.web.facade.exception.BaseException;
import com.kit101.web.facade.response.Rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @version V1.0
 * @author: k7kit
 * @date: 2020-04-26
 */
abstract class ExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

    BaseResponse handler(Exception ex, HttpServletRequest request) {
        BaseResponse re = Rest.error(ex);
        String uri = request.getRequestURI();
        if (ex instanceof BaseException) {
            // 业务定义异常，日志等级为warn
            log.warn("requestId: {},uri: {},\n {}: {}", re.getRequestId(), uri, ex.getClass().getName(), ex.getMessage());
        } else {
            // 系统异常，日志类型为error
            StackTraceElement s = ex.getStackTrace()[0];
            log.error("requestId: {},uri: {},\n {}.{}:{}\n {}: {}", re.getRequestId(), uri, s.getClassName(),
                    s.getMethodName(), s.getLineNumber(), ex.getClass().getName(), ex.getMessage());
            ex.printStackTrace();
        }
        return re;
    }
}
