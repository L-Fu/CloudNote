package com.liang.controller;

import com.liang.exception.MyException;
import com.liang.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(MyException.class)
    public Result MyException(MyException myException){
        myException.printStackTrace();
        Result<String> result = new Result<>();
        result.setCode(myException.getCode());
        result.setMessage(myException.getMessage());
        return result;
    }
}
