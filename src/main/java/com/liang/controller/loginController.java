package com.liang.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liang.dto.UserDTO;
import com.liang.pojo.User;
import com.liang.service.UserService;
import com.liang.util.UserHolder;
import com.liang.vo.LoginVO;
import com.liang.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static com.liang.constant.RedisPrefixConst.CAPTCHA_CODE_TTL;


/**
 * @author Liang
 */
@CrossOrigin
@Controller
@RequestMapping("/nologin")
public class loginController {
    @Autowired
    UserService userService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping(value = "/login")
    @ResponseBody
    public Result login(LoginVO loginVO, HttpServletResponse response){
        System.out.println(loginVO);
        String token = userService.login(loginVO);
        HashMap<String,String> map=new HashMap<>();
        map.put("token",token);
        return Result.ok(map);
    }

    @PostMapping("/logout")
    @ResponseBody
    public Result logOut(HttpServletResponse response, HttpServletRequest request){
        String token = request.getHeader("authorization");
        stringRedisTemplate.delete(token);
        UserHolder.saveUser(new UserDTO());
        return Result.ok("登出成功");
    }

    @PostMapping("/addUser")
    @ResponseBody
    public Result addUser( User user){
//        System.out.println(uid);
//        System.out.println(uid);
//        JSONObject userJson = JSONObject.parseObject(uid);
//        User user = JSON.toJavaObject(userJson,User.class);
//        System.out.println(user);
//        customerService.addDataLine(customer);

        String s = userService.addUser(user);
        return Result.ok(s);
    }
}
