package com.liang;

//import com.liang.e.UserDao;
import com.liang.mapper.CollectionMapper;
import com.liang.mapper.UserMapper;
import com.liang.pojo.User;
import com.liang.service.UserService;
import com.liang.vo.LoginVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CloudNoteApplicationTests {

    @Resource
//    private UserDao userMapper;
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Test

    void contextLoads() {
//        System.out.println(userMapper.queryUserById(10001));
        User user = new User();
        user.setUAccount("12");
        user.setUPassword("123");
        user.setUName("13");
//        System.out.println(userMapper.insert(user));
//        userMapper.insert(user);
//        System.out.println(userMapper.selectList(null));
//        LoginVO loginVO = new LoginVO("","admin","123456");
//        System.out.println(userService.login(loginVO));
//        System.out.println(userMapper.selectById(10001));

    }

}
