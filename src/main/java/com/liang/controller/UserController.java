package com.liang.controller;

import cn.hutool.http.HttpResource;
import com.liang.dto.UserDTO;
import com.liang.pojo.User;
import com.liang.service.UserService;
import com.liang.vo.LoginVO;
import com.liang.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

//@RestController("/user")
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public Result addUsrer(User user){
        String s = userService.addUser(user);
        return Result.ok(s);
    }

    @PostMapping("/delUser")
    public Result delUser(HttpServletResponse response){

        String s = userService.deleteUser();
        Cookie cookie = new Cookie("token","");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return Result.ok(s);
    }

    @PostMapping("/updateUser")
    public Result updateUser(User user){
        String s = userService.updateUser(user);
        return Result.ok(s);
    }

    @PostMapping("/queryUser")
    public Result queryUser(){
        UserDTO userDTO = userService.queryUser();
        return Result.ok(userDTO);
    }


    @PostMapping("/updatePasseord")
    public Result updatePassword(LoginVO loginVO){
        String s = userService.updateUserPassword(loginVO);
        return Result.ok(s);
    }



}
