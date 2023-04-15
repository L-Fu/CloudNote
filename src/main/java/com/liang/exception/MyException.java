package com.liang.exception;


import com.liang.enums.StatusCodeEnum;
import com.liang.util.UserHolder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static com.liang.enums.StatusCodeEnum.Auth_code_ERROR;


/**
 *自定义异常
 * @author Liang
 */
@Getter
@AllArgsConstructor
@Slf4j
public class MyException extends RuntimeException {

    /**
     * 错误码
     */
    private Integer code = Auth_code_ERROR.getCode();

    /**
     * 错误信息
     */
    private final String message;

    public MyException(String message) {
        this.message = message;
    }

    public MyException(StatusCodeEnum statusCodeEnum) {
        this.code = statusCodeEnum.getCode();
        this.message = statusCodeEnum.getDesc();
        if(UserHolder.getUser() != null){
            log.warn(String.valueOf(UserHolder.getId()),message);
        }else {
            log.warn(message, code);
        }

    }


}
