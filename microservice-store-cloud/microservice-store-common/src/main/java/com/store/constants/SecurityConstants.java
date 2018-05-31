package com.store.constants;

/**
 * @author lengleng
 * @date 2017-12-18
 */
public class SecurityConstants {

    /**
     * 前缀
     */
    public static final String PIG_PREFIX = "pig_";

    /**
     * 用户信息头
     */
    public static final String USER_HEADER = "x-user-header";

    /**
     * 角色信息头
     */
    public static final String ROLE_HEADER = "x-role-header";

    /**
     * 项目的license
     */
    public static final String PIG_LICENSE = "made by pig";

    /**
     * 基础角色
     */
    public static final String BASE_ROLE = "ROLE_USER";

    /**
     * 授权码模式
     */
    public static final String AUTHORIZATION_CODE = "authorization_code";

    /**
     * 密码模式
     */
    public static final String PASSWORD = "password";

    /**
     * 刷新token
     */
    public static final String REFRESH_TOKEN = "refresh_token";

    /**
     * oauth token
     */
    public static final String OAUTH_TOKEN_URL = "/oauth/token";

    /**
     * 手机登录URL
     */
    public static final String MOBILE_TOKEN_URL = "/mobile/token";

    /**
     * 默认的处理验证码的url前缀
     */
    public static final String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";

    /**
     * 手机号的处理验证码的url前缀
     */
    public static final String MOBILE_VALIDATE_CODE_URL_PREFIX = "/smsCode";

    /**
     * 默认生成图形验证码宽度
     */
    public static final String DEFAULT_IMAGE_WIDTH = "150";

    /**
     * 默认生成图像验证码高度
     */
    public static final String DEFAULT_IMAGE_HEIGHT = "32";

    /**
     * 默认生成图形验证码长度
     */
    public static final String DEFAULT_IMAGE_LENGTH = "4";

    /**
     * 默认生成图形验证码过期时间
     */
    public static final int DEFAULT_IMAGE_EXPIRE = 60;

    /**
     * 边框颜色，合法值： r,g,b (and optional alpha) 或者 white,black,blue.
     */
    public static final String DEFAULT_COLOR_FONT = "black";

    /**
     * 图片边框
     */
    public static final String DEFAULT_IMAGE_BORDER = "no";

    /**
     * 默认图片间隔
     */
    public static final String DEFAULT_CHAR_SPACE = "5";

    /**
     * 默认保存code的前缀
     */
    public static final String DEFAULT_CODE_KEY = "DEFAULT_CODE_KEY";

    /**
     * 验证码文字大小
     */
    public static final String DEFAULT_IMAGE_FONT_SIZE = "30";

    /**
     * token-uservo
     */
    public static final String TOKEN_USER_DETAIL = "token-user-detail";

    /**
     * 默认的social的登录地址
     */
    public static final String DEFAULT_SOCIAL_PROCESS_URL = "/social";

    /**
     * 默认的social的注册地址
     */
    public static final String DEFAULT_SOCIAL_SIGNUP_URL = "/social/signup";
}
