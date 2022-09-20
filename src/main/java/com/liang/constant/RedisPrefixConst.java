package com.liang.constant;



/**
 * redis常量
 */
public class RedisPrefixConst {

    /**
     * 登录验证码key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha:code:";
    /**
     * 登录验证码有效期
     */
    public static final Long CAPTCHA_CODE_TTL = 5L;
    public static final String LOGIN_USER_KEY = "login:token:";
    public static final Long LOGIN_USER_TTL = 15L;
    public static final String REGISTER_EMAIL_CODE = "email:code:";
    /**
     * 邮箱验证码有效期
     */
    public static final Long REGISTER_EMAIL_CODE_TTL = 5L;

    /**
     * 帖子具体数据
     */
    public static final String POSTS ="posts";
    public static final Long POSTS_CODE_TTL = 60*24L;
    /**
     * 帖子推送数据
     */
    public static final String POSTS_PUSH ="posts_push";
    public static final Long POSTS_PUSH_CODE_TTL = 60*24L;
    /**
     * 帖子浏览表
     */
    public static final String POSTS_VIEW_COUNT ="posts_view_count";

    /**
     * 帖子评论表
     */
    public static final String POSTS_COMMENT_COUNT ="posts_comment_count";

    /**
     * 帖子点赞表
     */
    public static final String POSTS_LIKE_COUNT ="posts_like_count";

    /**
     * 帖子收藏表
     */
    public static final String POSTS_COLLECT_COUNT ="posts_collect_count";

    /**
     * 帖子热度表   计算公式 热度值=浏览量+评论数*2+点赞数*3+收藏数*5
     */
    public static final String POSTS_HEAT_COUNT ="posts_heat_count";

    /**
     * 热度分区
     */

    //低级热度  100以下
    public static final String POSTS_LOW_HEAT ="posts_low_heat";

    //中级热度  100以上 1000以下
    public static final String POSTS_MIDDLE_HEAT ="posts_middle_heat";

    //高级热度  1000以上
    public static final String POSTS_HIGH_HEAT ="posts_high_heat";

    public static final long SHARE_NOTE = 15L;


}
