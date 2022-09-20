package com.liang.vo;

import com.liang.enums.StatusCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

import static com.liang.enums.StatusCodeEnum.*;


/**
 * 接口返回类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    /**
     * 返回状态
     */
    private Boolean flag;
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    // data--数据、message--信息、StatusCodeEnum--状态

    // 成功---不接受数据且不需要返回数据
    public static <T> Result<T> ok() {
        return restResult(true, null, SUCCESS.getCode(), SUCCESS.getDesc());
    }

    // 成功---接受数据且需要返回数据
    public static <T> Result<T> ok(T data) {
        return restResult(true, data, SUCCESS.getCode(), SUCCESS.getDesc());
    }

    public static <T> Result<T> ok(String message) {
        T data = null;
        HashMap<String,String> map = new HashMap<>();
        map.put("msg",message);
        data = (T) map;
        return restResult(true, data, SUCCESS.getCode(), message);
    }
    // 成功---接受数据和信息且需要返回数据
    public static <T> Result<T> ok(T data, String message) {
        return restResult(true, data, SUCCESS.getCode(), message);
    }

    // 失败---不接受数据且不需要返回数据
    public static <T> Result<T> fail() {
        return restResult(false, null, FAIL.getCode(), FAIL.getDesc());
    }

    // 失败---接受状态、不需要返回数据
    public static <T> Result<T> fail(StatusCodeEnum statusCodeEnum) {
        return restResult(false, null, statusCodeEnum.getCode(), statusCodeEnum.getDesc());
    }

    // 失败---接受信息
    public static <T> Result<T> fail(String message) {
        return restResult(false, message);
    }

    // 失败---接收数据
    public static <T> Result<T> fail(T data) {
        return restResult(false, data, FAIL.getCode(), FAIL.getDesc());
    }

    // 失败--接收数据和信息
    public static <T> Result<T> fail(T data, String message) {
        return restResult(false, data, FAIL.getCode(), message);
    }

    // 失败--接收状态码和信息
    public static <T> Result<T> fail(Integer code, String message) {
        return restResult(false, null, code, message);
    }


    //
    private static <T> Result<T> restResult(Boolean flag, String message) {
        Result<T> apiResult = new Result<>();
        apiResult.setFlag(flag);
        // 判断成功还是失败
        apiResult.setCode(flag ? SUCCESS.getCode() : FAIL.getCode());
        apiResult.setMessage(message);
        return apiResult;
    }

    private static <T> Result<T> restResult(Boolean flag, T data, Integer code, String message) {
        Result<T> apiResult = new Result<>();
        apiResult.setFlag(flag);
        apiResult.setData(data);
        apiResult.setCode(code);
        apiResult.setMessage(message);
        return apiResult;
    }


}

