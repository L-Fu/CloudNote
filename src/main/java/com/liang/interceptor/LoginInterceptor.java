package com.liang.interceptor;


import com.liang.exception.MyException;
import com.liang.util.UserHolder;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.liang.enums.StatusCodeEnum.User_Login_ERROR;


/**
 * @author Liang
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");
//        System.out.println("login拦截器");
        // 1.判断是否需要拦截（ThreadLocal中是否有用户）
        if (UserHolder.getUser() == null) {
            // 抛出用户未登录的异常
            throw new MyException(User_Login_ERROR);
        }
        // 有用户，则放行
        return true;
    }
}
