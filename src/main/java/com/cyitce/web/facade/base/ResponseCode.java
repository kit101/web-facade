package com.cyitce.web.facade.base;

/**
 * @version V1.0
 * @desc: 定义基本返回码
 * @author: k7kit
 * @date: 2019-10-14
 */
public enum ResponseCode implements Message {
    /**
     * 正常执行
     */
    SUCCESS(0,"成功"),

    /**
     * 系统错误
     */
    UNKNOW_ERROR(10001,"未知错误"),
    SYSTEM_BUSY(10002,"系统繁忙"),
    FORBID_ACCESS(10003,"禁止访问"),
    DATABASE_ERROR(10004,"数据库错误"),
    /**
     * 身份认证
     */
    INCORRECT_USERNAME_OR_PASSWORD(10101,"账号或密码错误"),
    MISSING_ACCESS_TOKEN(10102,"缺少access token"),
    DUPLICATE_LOGIN(10103,"重复登录"),
    INVALID_ACCESS_TOKEN(10104,"无效access token"),
    EXPIRED_ACCESS_TOKEN(10105,"access token过期"),
    /**
     * 客户端调用不正确
     */
    CLIENT_CALL_ERROR(20001,"客户端调用错误，见详细描述"),
    WRONG_FILE_TYPE(20002,"文件类型错误"),
    JSON_FORMAT_ERROR(20003,"json格式错误"),
    PARAM_OUT_OF_RANGE(20004,"参数越界"),
    DATA_TOO_LARGE(20005,"数据过大"),
    PARAMETER_VALIDATION_ERROR(20006, "参数不合法"),
    /**
     * 权限
     */
    PERMISSION_DENIED(30001,"无权限"),
    PERMISSION_ACCESS_DENIED(30002,"无权限访问"),
    PERMISSION_MODIFY_DENIED(30003,"无权限修改（增、删、改）"),
    /**
     *  资源操作未正常执行
     */
    NO_RESOURCES_FOUND(40001,"没有查询到资源"),
    RESOUCE_INSERTED_ALREADY_EXISTS(40002,"新增资源已存在"),
    RESOUCE_DELETED_NON_EXISTENT(40003,"要删除资源不存在"),
    RESOURCE_NOT_UPDATED(40004,"资源未更新"),
    FREQUENT_OPERATION(40005,"操作频繁"),
    FILE_TOO_LARGE(40030,"文件大小超过限制"),
    FAILED_TO_UPLOAD_FILE(40031,"上传文件失败"),
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
