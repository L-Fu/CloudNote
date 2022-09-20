package com.liang.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 登录提交

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class LoginVO {

    private String userName;

    private long uId;

    /**
     * 专属ID
     */
    private String account;

    /**
     * 验证码
     */
    private String password;

}
