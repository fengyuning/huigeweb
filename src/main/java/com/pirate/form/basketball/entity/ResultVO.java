package com.pirate.form.basketball.entity;


import com.pirate.form.basketball.enums.ResultCodeEnum;

/**
 * 接口返回对象
 *
 * @author fengyn
 * @version 2019/01/26
 */
public class ResultVO<T> {

    private Integer code;
    private String msg;
    private T data;

    //支持传自定义状态码的方式
    public ResultVO(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMsg();
    }

    //成功
    public static ResultVO success(Object data) {
        ResultVO<Object> result = new ResultVO<>(ResultCodeEnum.SUCCESS);
        result.setData(data);
        return result;
    }

    //未知错误
    public static ResultVO unkonwError(Object data) {
        ResultVO<Object> result = new ResultVO<>(ResultCodeEnum.UNKONW_ERROR);
        result.setData(data);
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}