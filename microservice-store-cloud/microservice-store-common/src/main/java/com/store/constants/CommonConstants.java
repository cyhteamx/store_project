package com.store.constants;

/**
 * CommonConstants.class
 * Description:
 *  常量类
 */
public class CommonConstants {

    /**
     * 成功返回数据
     */
    public static final Integer RESPONSE_SUCCESS = 200;
    public static final String RESPONSE_SUCCESS_MSG = "response success !";


    /**
     * 账户密码登录校验
     */
    public static final Integer EX_USER_INVALID_CODE = 40101;
    public static final String EX_USER_INVALID_MSG = "User loginName or password Error!";
    /**
     * token校验
     */
    public static final Integer EX_TOKEN_ERROR_CODE = 40102;
    public static final String EX_TOKEN_ERROR_MSG = "Token error or Token is expired.";
    /**
     * 服务鉴权
     */
    public static final Integer EX_CLIENT_INVALID_CODE = 40201;
    public static final String EX_CLIENT_INVALID_MSG = "Client not foud or Client secret is error!";

    public static final Integer EX_CLIENT_FORBIDDEN_CODE = 40331;
    public static final Integer EX_OTHER_CODE = 500;

    /**
     * 当期登录用户信息常量
     */
    public static final String CONTEXT_KEY_USER_ID = "currentUserId";
    public static final String CONTEXT_KEY_LOGIN_NAME = "currentLoginName";
    public static final String CONTEXT_KEY_USER_NAME = "currentUserName";
    public static final String JWT_KEY_USER_ID = "userId";
    public static final String JWT_KEY_NAME = "name";

    /**
     * JWT相关常量
     */
    public static final String JWT_PUB_KEY_PATH_WIN = "classpath:jwt/pub.key";
    public static final String JWT_PRI_KEY_PATH_WIN = "classpath:jwt/pri.key";
    public static final String JWT_PUB_KEY_PATH_LINUX = "/root/token/jwt/pub.key";
    public static final String JWT_PRI_KEY_PATH_LINUX = "/root/token/jwt/pri.key";
    public static final String JWT_ACCESS_TOKEN = "access-token";
    //60 min
    public static final Integer JWT_ACCESS_EXPIRE = 60;

    /**
     * 客户端相关常量
     */
    public static final String CLIENT_PUB_KEY_PATH_WIN = "classpath:client/pub.key";
    public static final String CLIENT_PRI_KEY_PATH_WIN = "classpath:client/pri.key";
    public static final String CLIENT_PUB_KEY_PATH_LINUX = "/root/token/client/pub.key";
    public static final String CLIENT_PRI_KEY_PATH_LINUX = "/root/token/client/pri.key";
    public static final String CLIENT_ACCESS_TOKEN = "client-token";
    //60 min
    public static final Integer CLIENT_ACCESS_EXPIRE = 60;

    /**
     *
     *
     */
    public final static String RESOURCE_TYPE_MENU = "menu";
    public final static String RESOURCE_TYPE_BTN = "button";
}
