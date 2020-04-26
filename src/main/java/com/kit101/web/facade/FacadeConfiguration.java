package com.kit101.web.facade;

import com.kit101.web.facade.base.BaseCode;
import com.kit101.web.facade.base.BaseResponse;
import com.kit101.web.facade.base.Code;
import com.kit101.web.facade.resolver.GlobalExceptionResolver;
import com.kit101.web.facade.response.ErrorResponse;
import com.kit101.web.facade.response.OkResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @version V1.0
 * @desc:
 * @author: k7kit
 * @date: 2019-10-23
 */
@Configuration
public class FacadeConfiguration {


    @Bean
    public GlobalExceptionResolver glableExceptionResolver() {
        return new GlobalExceptionResolver();
    }


    @RestControllerAdvice
    static class RestResponseAdvice implements ResponseBodyAdvice<Object> {

        private static final Logger log = LoggerFactory.getLogger(RestResponseAdvice.class);

        public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
            return true;
        }

        /**
         * 输出前处理
         *
         * @param body
         * @param methodParameter
         * @param mediaType
         * @param aClass
         * @param serverHttpRequest
         * @param serverHttpResponse
         * @return {@link Object}
         * @author k7kit
         * @date 2020-04-26
         */
        public Object beforeBodyWrite(Object body, MethodParameter methodParameter,
                                      MediaType mediaType,
                                      Class<? extends HttpMessageConverter<?>> aClass,
                                      ServerHttpRequest serverHttpRequest,
                                      ServerHttpResponse serverHttpResponse) {
            log.debug("beforeBodyWrite: {}", body.getClass());
            if (body instanceof BaseResponse) {
                // 未知错误, http status = 500
                if (((Code) body).getCode() == BaseCode.UNKNOWN_ERROR.getCode()) {
                    serverHttpResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
                    return body;
                }
                if (body instanceof OkResponse) {
                    OkResponse returnResponse = (OkResponse) body;
                    if (returnResponse.getCode() == BaseCode.SUCCESS.getCode()) {
                        if (isBaseClass(returnResponse.getData())) {
                            Map<String, Object> data = new LinkedHashMap<>();
                            data.put("data", returnResponse.getData());
                            return data;
                        } else {
                            return returnResponse.getData();
                        }
                    }
                }
                // 业务错误, 使用用户定义状态码
                if (body instanceof ErrorResponse) {
                    ErrorResponse errorResponse = (ErrorResponse) body;
                    serverHttpResponse.setStatusCode(errorResponse.httpStatus());
                }
            }
            return body;
        }

        /**
         * 是否为基础数据类型或String
         *
         * @param o
         * @return {@link boolean}
         * @author k7kit
         * @date 2020-04-26
         */
        private boolean isBaseClass(Object o) {
            Class clazz = o.getClass();
            return (clazz.equals(Integer.class) || clazz.equals(int.class) ||
                    clazz.equals(Byte.class) || clazz.equals(byte.class) ||
                    clazz.equals(Long.class) || clazz.equals(long.class) ||
                    clazz.equals(Double.class) || clazz.equals(double.class) ||
                    clazz.equals(Float.class) || clazz.equals(float.class) ||
                    clazz.equals(Character.class) || clazz.equals(char.class) ||
                    clazz.equals(Short.class) || clazz.equals(short.class) ||
                    clazz.equals(Boolean.class) || clazz.equals(boolean.class) ||
                    clazz.equals(String.class));
        }
    }


}
