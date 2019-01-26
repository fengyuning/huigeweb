package com.pirate.form.basketball.enums;

/**
 * 自定义状态码
 *
 * @author fengyn
 * @version 2019/01/26
 */
public enum ResultCodeEnum {

    SUCCESS(200, "成功"),
    PARAMETER_ERROR(400, "参数错误"),
    SYSTEM_ERROR(500, "系统异常"),
    UNKONW_ERROR(-1, "未知错误");

    private Integer code;
    private String msg;

    ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
