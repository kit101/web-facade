package com.cyitce.web.facade.base;

/**
 * @version V1.0
 * @desc:
 * @author: k7kit
 * @date: 2019-10-14
 */
public enum ResponseCode implements Message {
    //10000 开头为通用错误类型
    PARAMETER_VALIDATION_ERROR(10001, "参数不合法"),
    UNKNOW_ERROR(10002, "未知错误"),

    //20000 开头为用户相关错误
    USER_REGISTER_NOT_USER(20001, "注册信息有误，请重试"),
    USER_REGISTER_EXIT_USER(20002, "用户已存在，请重试"),
    USER_REGISTER_FAIL(20003, "注册失败，请重试"),

    //30000 开头为交易型错误
    ;

    private int errCode;
    private String errMsg;

    private ResponseCode(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }


    @Override
    public int getCode() {
        return this.errCode;
    }

    @Override
    public String getMessage() {
        return this.errMsg;
    }

    @Override
    public Message setMassage(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
