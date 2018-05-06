package com.store.utils.jwt;

/**
 * Created by ace on 2017/9/10.
 */
public interface IJWTInfo {
    /**
     * 获取用户登录
     */
    String getLoginName();

    /**
     * 获取用户ID
     */
    String getId();

    /**
     * 获取用户名
     */
    String getName();
}
