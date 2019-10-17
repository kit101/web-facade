package com.cyitce.web.facade.base;

import java.util.Date;
import java.util.UUID;

/**
 * @version V1.0
 * @desc:
 * @author: k7kit
 * @date: 2019-10-14
 */
public abstract class BaseResponse implements Code {

    private String requestId = UUID.randomUUID().toString().replace("-", "");

    public Date getDate() {
        return new Date();
    }

    public String getRequestId() {
        return requestId ;
    }

}
