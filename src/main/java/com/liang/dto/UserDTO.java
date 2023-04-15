package com.liang.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Liang
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private long uId;
    /**
     * 用户名
     */
    private String uName;
    /**
     * 账号
     */
    private String uAccount;
    /**
     * 用户简介
     */
    private String uDesc;
    /**
     * 用户头像
     */
    private String icon;

}
