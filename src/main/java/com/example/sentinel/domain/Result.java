package com.example.sentinel.domain;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author Hz~
 * @version 1.0
 * @date 2020/10/26 14:19
 * @Description 全局返回结果类
 */
@Data
public class Result<T> implements Serializable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 消息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result() {
    }

    public static <T> Result<T> ok(String msg, T data) {
        return new Result<T>(HttpStatus.OK.value(), msg, data);
    }

    public static <T> Result<T> ok() {
        return new Result<T>(HttpStatus.OK.value(), "request sucess!", null);
    }

    public static <T> Result<T> ok(T data) {
        return ok("request success!", data);
    }

    public static <T> Result<T> fail(String msg, T data) {
        return new Result<T>(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, data);
    }

    public static <T> Result<T> sentinelError(T data) {
        return sentinelError("当前操作人数过多，请重试！", data);
    }

    public static <T> Result<T> sentinelError(String msg, T data) {
        return new Result<T>(HttpStatus.TOO_MANY_REQUESTS.value(), msg, data);
    }


    public static <T> Result<T> fail(String msg) {
        return fail(msg, null);
    }
}
