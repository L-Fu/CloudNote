package com.liang.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 接口状态码枚举
 **/
@Getter
@AllArgsConstructor
public enum StatusCodeEnum {
    /**
     * 成功
     */
    SUCCESS(20000, "操作成功"),
    /**
     * 没有操作权限
     */
    AUTHORIZED(40300, "没有操作权限"),
    /**
     * 系统异常
     */
    SYSTEM_ERROR(50000, "系统异常"),
    /**
     * 失败
     */
    FAIL(51000, "操作失败"),
    /**
     * 参数校验失败
     */
    VALID_ERROR(52000, "参数格式不正确"),
    /**
     * 用户名已存在
     */
    USERNAME_EXIST(52001, "账号已存在"),
    /**
     * 用户名不存在
     */
    USERNAME_NOT_EXIST(52002, "用户名不存在"),
    /**
     * 密码错误
     */
    Password_EXIST(52003, "密码错误"),
    /**
     * 验证码错误
     */
    Auth_code_ERROR(52004, "验证码错误"),
    /**
     * 邮箱bu不存在
     */
    Email_belongTo_ERROR(52004, "邮箱不是你的或者你邮箱打错了"),
    /**
     * 热度分区错误
     */
    Set_Heat_ERROR(52005, "热度分区,暗号不对"),
    /**
     * 该帖子不属于该用户
     */
    User_Post_ERROR(52005, "这个帖子不属于你哦！"),
    /**
     * 用户未登录
     */
    User_Login_ERROR(52005, "用户未登录！"),
    /**
     * token失效
     */
    User_Token_ERROR(52222, "token失效"),
    /**
     * 创建邮件失败
     */
    Create_Email_ERROR(52222, "创建邮件失败"),
    /**
     * 笔记不存在
     */
    POST_NOT_EXIST(520935, "笔记不存在"),
    /**
     *
     * 删除失败
     */
    SHARE_NOTE_ERROR(52223,"链接失效");




    /**
     * 描述
     */
    private final Integer code;
    private final String desc;


}
