package com.store.constants;

/**
 * @author lengleng
 * @date 2017-12-18
 */
public interface SecurityConstants {

    /**
     * 前缀
     */
    String PIG_PREFIX = "pig_";

    /**
     * 用户信息头
     */
    String USER_HEADER = "x-user-header";

    /**
     * 角色信息头
     */
    String ROLE_HEADER = "x-role-header";

    /**
     * 项目的license
     */
    String PIG_LICENSE = "made by pig";

    /**
     * 基础角色
     */
    String BASE_ROLE = "ROLE_USER";

    /**
     * 授权码模式
     */
    String AUTHORIZATION_CODE = "authorization_code";

    /**
     * 密码模式
     */
    String PASSWORD = "password";

    /**
     * 刷新token
     */
    String REFRESH_TOKEN = "refresh_token";

    /**
     * oauth token
     */
    String OAUTH_TOKEN_URL = "/oauth/token";

    /**
     * 手机登录URL
     */
    String MOBILE_TOKEN_URL = "/mobile/token";

    /**
     * 默认的处理验证码的url前缀
     */
    String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";

    /**
     * 手机号的处理验证码的url前缀
     */
    String MOBILE_VALIDATE_CODE_URL_PREFIX = "/smsCode";

    /**
     * 默认生成图形验证码宽度
     */
    String DEFAULT_IMAGE_WIDTH = "150";

    /**
     * 默认生成图像验证码高度
     */
    String DEFAULT_IMAGE_HEIGHT = "32";

    /**
     * 默认生成图形验证码长度
     */
    String DEFAULT_IMAGE_LENGTH = "4";

    /**
     * 默认生成图形验证码过期时间
     */
    int DEFAULT_IMAGE_EXPIRE = 60;

    /**
     * 边框颜色，合法值： r,g,b (and optional alpha) 或者 white,black,blue.
     */
    String DEFAULT_COLOR_FONT = "black";

    /**
     * 图片边框
     */
    String DEFAULT_IMAGE_BORDER = "no";

    /**
     * 默认图片间隔
     */
    String DEFAULT_CHAR_SPACE = "5";

    /**
     * 默认保存code的前缀
     */
    String DEFAULT_CODE_KEY = "DEFAULT_CODE_KEY";

    /**
     * 验证码文字大小
     */
    String DEFAULT_IMAGE_FONT_SIZE = "30";

    /**
     * token-uservo
     */
    String TOKEN_USER_DETAIL = "token-user-detail";

    /**
     * 默认的social的登录地址
     */
    String DEFAULT_SOCIAL_PROCESS_URL = "/social";

    /**
     * 默认的social的注册地址
     */
    String DEFAULT_SOCIAL_SIGNUP_URL = "/social/signup";


    /**
     * sys_oauth_client_details 表的字段，不包括client_id、client_secret
     */
    String CLIENT_FIELDS = "client_id, client_secret, resource_ids, scope, "
            + "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
            + "refresh_token_validity, additional_information, autoapprove";

    /**
     *JdbcClientDetailsService 查询语句
     */
    String BASE_FIND_STATEMENT = "select " + CLIENT_FIELDS
            + " from tb_sys_oauth_client_details";

    /**
     * 默认的查询语句
     */
    String DEFAULT_FIND_STATEMENT = BASE_FIND_STATEMENT + " order by client_id";

    /**
     * 按条件client_id 查询
     */
    String DEFAULT_SELECT_STATEMENT = BASE_FIND_STATEMENT + " where client_id = ?";

    String PRIVATE_KEY_SIGNING_KEY = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEogIBAAKCAQEA5aP/2VEGL/ZneHWof9prZTLbrS6WVAyLsADq4HE6Jzhpdvqi\n" +
            "JRNRFmMJZjWXgQAuT+IdhLQJZWZKBhCWKs6m8nUWKVN3C2/gFKIud9NMsYZh5FGP\n" +
            "ftE0r1wKKBr4/FCKPvQ+azTENRLa9nL/OCfW9Um2FnA3OZ2O1t83r8OEk2Ks9wjR\n" +
            "YoH90pH8hqIjrJKvImlpSTCctzrhzr4UPuA9takH9XJJR44eopbaTPD/JpmysnzS\n" +
            "vj7Zo7RUmDbmyVW0PP67LBRF5uZikujsixKMlHzJgatsD4mLEc5VvbR+GqZ4zc1n\n" +
            "ilYt4GgqM5pzP2v59IdqPzUpP7xFIb1arD/8iwIDAQABAoIBAA/dtN+e6X6G179K\n" +
            "4clzndfwG51ripdkBoKyjYfUSuBK1X6S8oD9RKz3Sr71FPKkwI5kYQW6KqwG1TZ2\n" +
            "DuoGPSKjVFSmn6L6p9DFI9DDmJjrX/gWaoOokKtNAKaktm84YVTYKzfc/XFtTBOa\n" +
            "/mcy2Xc5EIucVTR13liaM47BQ3erSCYQJvqxf0TZA1uqjJD9JHbtgijoEcE8IqqC\n" +
            "WN4NRVIugj/qJqwIvjhOzXNGbuumNKkA78xoJLIAuLrYh7HoS0jvNAp7BQXqnY6G\n" +
            "HW/cwatom/UpXpCn+cFLhQ5U7b+ulnQ0n20lP1C4sSfrwQdNhFRz5srxIe86E8yl\n" +
            "devOHoECgYEA9e8oKJbkjvkIQSC8sXpQUhGHO7z/m1ZU3khsjtBAdrtsMzhPVZqE\n" +
            "B4rqF7DHN5JyoYCsX0FDBGV6b7jR8WKIGacXPFEdWI2m1j8OCtVhza12udU54ql1\n" +
            "LxFp6uvBxogIesTIAH/wm8B1ctP/UIxnRNVeODyNFEWbYh0v8ZAhH4UCgYEA7wof\n" +
            "PlhAmelaOq5h0Ia9/AtYKnid28OeVI/8TGuQNV5uVUe+K2k6W8g9K2znnsEXq+y/\n" +
            "q7kkejXHTvXwH1POqsx91D6F4Yk2TkxpIZkSWu99DRX60wI0VgzCIszcUubzlPHH\n" +
            "r07hs0HetYeVM7a4EF/ThxuJgJp3joKsBYhxgM8CgYB9L8/xWV3eqUVaYZ+rd+eK\n" +
            "3wFHl11FZRyuSY944ujth1n8eJ1ppc2vSTb/+CxwTUusiiM0GbRTeJRqalnz1YQS\n" +
            "Csv5GBEoEnLqfA5Z1WSDndjhn3hnuHq+Cs8vlfJ9bKFkXOax2m5P2hfu65r7FX07\n" +
            "vKDJX4kw2H3P46uT+xnhQQKBgESsV8WFfSm6jJ2HM7rAuxwJ9k5dUJyuWnJY21bp\n" +
            "IAj1FCWT8uJt3MI5iLlNFE3bk31lCru++OfTQ2s/5LhbT2hqT0wGmlftH5jnAt0Q\n" +
            "KOHPI9H6mpC8dWSzTaLJ0BJRH3GO9Js8wkLJjb4BMbAlskOiBBcwphQ4TFi42crN\n" +
            "JC6pAoGAAe3I4OFaJOmQgDkf8NZ8n0bk8shSDNeWXtRudoTGHuf7brdyX3RxS7ui\n" +
            "jhUiwj0ENEBtHuxpxdP1rR95Ti5m80folqKuUKZmfwcQx8Eh16mQeg8x5OziDDaz\n" +
            "4egrrINBkb62RaS32VyT+becVqzGB0dJaLVDdYGwoqAYYNL+nZU=\n" +
            "-----END RSA PRIVATE KEY-----\n";

    String PUBLIC_VERIFY_KEY = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5aP/2VEGL/ZneHWof9pr\n" +
            "ZTLbrS6WVAyLsADq4HE6JzhpdvqiJRNRFmMJZjWXgQAuT+IdhLQJZWZKBhCWKs6m\n" +
            "8nUWKVN3C2/gFKIud9NMsYZh5FGPftE0r1wKKBr4/FCKPvQ+azTENRLa9nL/OCfW\n" +
            "9Um2FnA3OZ2O1t83r8OEk2Ks9wjRYoH90pH8hqIjrJKvImlpSTCctzrhzr4UPuA9\n" +
            "takH9XJJR44eopbaTPD/JpmysnzSvj7Zo7RUmDbmyVW0PP67LBRF5uZikujsixKM\n" +
            "lHzJgatsD4mLEc5VvbR+GqZ4zc1nilYt4GgqM5pzP2v59IdqPzUpP7xFIb1arD/8\n" +
            "iwIDAQAB\n" +
            "-----END PUBLIC KEY-----";

}
