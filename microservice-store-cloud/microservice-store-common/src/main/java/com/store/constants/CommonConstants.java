package com.store.constants;

/**
 * CommonConstants.class
 * Description:
 *  常量类
 */
public interface CommonConstants {

    /**
     * 成功返回数据
     */
    Integer RESPONSE_SUCCESS = 200;
    String RESPONSE_SUCCESS_MSG = "response success !";


    /**
     * 账户密码登录校验
     */
    Integer EX_USER_INVALID_CODE = 40101;
    String EX_USER_INVALID_MSG = "User loginName or password Error!";
    /**
     * token校验
     */
    Integer EX_TOKEN_ERROR_CODE = 40102;
    String EX_TOKEN_ERROR_MSG = "Token error or Token is expired.";
    /**
     * 服务鉴权
     */
    Integer EX_CLIENT_INVALID_CODE = 40201;
    String EX_CLIENT_INVALID_MSG = "Client not foud or Client secret is error!";

    Integer EX_CLIENT_FORBIDDEN_CODE = 40331;
    Integer EX_OTHER_CODE = 500;

    /**
     * 当期登录用户信息常量
     */
    String CONTEXT_KEY_USER_ID = "currentUserId";
    String CONTEXT_KEY_LOGIN_NAME = "currentLoginName";
    String CONTEXT_KEY_USER_NAME = "currentUserName";
    String JWT_KEY_USER_ID = "userId";
    String JWT_KEY_NAME = "name";
    String JWT_KEY_ROLETYPE = "roleType";

    /**
     * JWT相关常量
     */
    String JWT_PUB_KEY_PATH_WIN = "classpath:jwt/pub.key";
    String JWT_PRI_KEY_PATH_WIN = "classpath:jwt/pri.key";
    String JWT_PUB_KEY_PATH_LINUX = "/root/token/jwt/pub.key";
    String JWT_PRI_KEY_PATH_LINUX = "/root/token/jwt/pri.key";
    String JWT_ACCESS_TOKEN = "access-token"; //access-token
    //60 min
    Integer JWT_ACCESS_EXPIRE = 60;

    /**
     * 客户端相关常量
     */
    String CLIENT_PUB_KEY_PATH_WIN = "classpath:client/pub.key";
    String CLIENT_PRI_KEY_PATH_WIN = "classpath:client/pri.key";
    String CLIENT_PUB_KEY_PATH_LINUX = "/root/token/client/pub.key";
    String CLIENT_PRI_KEY_PATH_LINUX = "/root/token/client/pri.key";
    String CLIENT_ACCESS_TOKEN = "client-token";
    //60 min
    Integer CLIENT_ACCESS_EXPIRE = 60;

    /**
     *
     *
     */
    String RESOURCE_TYPE_MENU = "menu";
    String RESOURCE_TYPE_BTN = "button";

    /**
     * token请求头名称
     */
    String REQ_HEADER = "Authorization";


    /**
     * token分割符
     */
    String TOKEN_SPLIT = "Bearer ";

    /**
     * jwt签名
     */
    String SIGN_KEY = "PIG";

    /**
     * 删除
     */
    Integer STATUS_DEL = 1;

    /**
     * 正常
     */
    Integer STATUS_NORMAL = 0;

    /**
     * 锁定
     */
    Integer STATUS_LOCK = 9;

    /**
     * 菜单
     */
    Integer MENU = 0;

    /**
     * 按钮
     */
    String BUTTON = "1";

    /**
     * 删除标记
     */
    String DEL_FLAG = "del_flag";

    /**
     * 编码
     */
    String UTF8 = "UTF-8";

    /**
     * JSON 资源
     */
    String CONTENT_TYPE = "application/json; charset=utf-8";

    /**
     * 阿里大鱼
     */
    String ALIYUN_SMS = "aliyun_sms";

    /**
     * 路由信息Redis保存的key
     */
    String ROUTE_KEY = "_ROUTE_KEY";

}
