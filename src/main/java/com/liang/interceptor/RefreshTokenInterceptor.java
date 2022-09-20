package com.liang.interceptor;

import cn.hutool.core.util.StrUtil;
import com.liang.dto.UserDTO;
import com.liang.exception.MyException;
import com.liang.service.UserService;
import com.liang.util.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static com.liang.constant.RedisPrefixConst.CAPTCHA_CODE_TTL;
import static com.liang.enums.StatusCodeEnum.User_Token_ERROR;


/**
 * @author Liang
 */
public class RefreshTokenInterceptor implements HandlerInterceptor {

//    @Autowired
//    private UserService userService;

    private StringRedisTemplate stringRedisTemplate;


    public RefreshTokenInterceptor(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(request.getMethod().equals("OPTONS")){
        }
//       response.setHeader("Access-Control-Allow-Origin", "Authorization");
//        System.out.println(ken);
//        System.out.println(handler.toString());
//        response.setHeader("Access-Control-Allow-Origin",request.getHeader("handler"));
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
//        response.addHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
//        response.addHeader("Access-Control-Max-Age", "120");
        // 1.获取请求头中的token
//        System.out.println(request.getHeader("authorization"));
        String token = request.getHeader("Authorization");
////        System.out.println("拦截器");
//        System.out.println(str);
//        String token = StrUtil.removePrefix(str, "Bearer");
//        System.out.println("token拦截器");
//        String token= null;
//        Cookie[] cookies = request.getCookies();
//        System.out.println(Arrays.toString(cookies));
//        Cookie isCookie = null;
//        if (!Objects.isNull(cookies)){
////            return true;
//
//            for (Cookie cookie : cookies){
//                if (cookie.getName().contentEquals("token")){
//                    isCookie = cookie;
//                }
//            }
//            assert isCookie != null;
//            token = isCookie.getValue();
//            System.out.println("token="+token);
//        }

        if (StrUtil.isBlank(token)) {
            return true;
        }
        // 除去token前后的空格
//        token=token.trim();

        // 3.判断用户token是否有效
        if (Objects.isNull(stringRedisTemplate.opsForValue().get(token))) {
//            isCookie.setMaxAge(0);
//            response.addCookie(isCookie);
            throw new MyException(User_Token_ERROR);
        }
//        System.out.println(token);

        UserDTO userDTO = new UserDTO();
        userDTO.setUId(Long.parseLong(Objects.requireNonNull(stringRedisTemplate.opsForValue().get(token))));
//        userDTO = userService.queryUser(userDTO);
        // 6.存在，保存用户信息到 ThreadLocal
//        System.out.println(userDTO);
        UserHolder.saveUser(userDTO);
        // 7.刷新token有效期
        stringRedisTemplate.expire(token, CAPTCHA_CODE_TTL, TimeUnit.DAYS);

//        isCookie.setMaxAge((int) TimeUnit.DAYS.toSeconds(CAPTCHA_CODE_TTL));
//        response.addCookie(isCookie);
        // 8.放行
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 移除用户
        UserHolder.removeUser();
    }
}
