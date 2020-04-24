package com.cyitce.web.facade.base;

import java.util.UUID;

/**
 * @version V1.0
 * @desc: 基础响应信息
 * @author: k7kit
 * @date: 2019-10-14
 */
public abstract class BaseResponse<T> implements Code {


    private String requestId = UUID.randomUUID().toString().replace("-", "");


    /**
     * requestId方便追踪定位错误，每次响应都是唯一的uuid.
     *
     * @return
     */
    public String getRequestId() {
        return requestId;
    }

}
