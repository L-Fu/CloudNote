package com.liang.service.impl;

import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.liang.dto.UserDTO;
import com.liang.exception.MyException;
import com.liang.mapper.UserMapper;
import com.liang.pojo.User;
import com.liang.service.UserService;
import com.liang.util.UserHolder;
import com.liang.vo.LoginVO;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static com.liang.constant.RedisPrefixConst.*;
import static com.liang.enums.StatusCodeEnum.*;

/**
 * @author Liang
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private UserMapper userMapper;


    @Override
    public String login(LoginVO loginVO) {
        System.out.println("loginVO");
        System.out.println(loginVO);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uAccount",loginVO.getAccount());
//        System.out.println("登录的用户为："+loginVO.getUserName());
        User user = userMapper.selectOne(queryWrapper);
//        System.out.println("user");
//        System.out.println(user);
        if(Objects.isNull(user)){
            throw new MyException(USERNAME_NOT_EXIST);
        }else if(!user.getUPassword().equals(loginVO.getPassword())){
            throw new MyException(Password_EXIST);
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setUId(user.getUId());
        UserHolder.saveUser(userDTO);

        //生成一个token
        String token = UUID.randomUUID(true).toString();
        System.out.println(token);

        QueryWrapper<User> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("uAccount",loginVO.getAccount());
        User user1 = userMapper.selectOne(queryWrapper);
        // 将用户id放入redis
        stringRedisTemplate.opsForValue().set(token, String.valueOf(user1.getUId()));
        // 设置过期时间

        stringRedisTemplate.expire(token,LOGIN_USER_TTL, TimeUnit.DAYS);
        return token;
    }

    @Override
    public UserDTO queryUser() {
        UserDTO userDTO = new UserDTO();
        User user = userMapper.selectById(UserHolder.getId());
//        System.out.println(user);
        userDTO.setAccount(user.getUAccount());
        userDTO.setIcon(user.getIcon());
        userDTO.setUDesc(user.getUDesc());
        userDTO.setUName(user.getUName());
        userDTO.setUId(user.getUId());
        UserHolder.saveUser(userDTO);
        return userDTO;
    }

    @Override
    public String updateUserPassword(LoginVO loginVO) {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        User user = new User();
        wrapper.eq("uid",UserHolder.getId());
        user.setUPassword(loginVO.getPassword());
        if(userMapper.update(user,wrapper) == 1){
            return "操作成功";
        }else {
            throw new MyException(FAIL);
        }
    }

    @Override
    public String deleteUser() {
        if (userMapper.deleteById(UserHolder.getId()) == 1){
            return "操作成功";
        }else {
            throw new MyException(USERNAME_NOT_EXIST);
        }
    }

    @Override
    public String addUser(User user) {
        System.out.println(user);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uAccount",user.getUAccount());
        if (Objects.isNull(userMapper.selectOne(queryWrapper))){
            if (userMapper.insert(user) == 1){
                System.out.println("操作成功");
                return "操作成功";
            }else {
                throw new MyException(FAIL);
            }
        }else {
            throw new MyException(USERNAME_EXIST);
        }

    }

    @Override
    public String updateUser(User user) {
        user.setUId(UserHolder.getId());
        if(userMapper.updateById(user) == 1){
            return "操作成功";
        }else {
            throw new MyException(FAIL);
        }
    }
}
