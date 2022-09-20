package com.liang.service;

import com.liang.dto.UserDTO;
import com.liang.pojo.User;
import com.liang.vo.LoginVO;

/**
 * @author Liang
 */
public interface UserService {
    String login(LoginVO loginVO);

    UserDTO queryUser();
    String updateUserPassword(LoginVO loginVO);
    String deleteUser();
    String addUser(User user);
    String updateUser(User user);
}
