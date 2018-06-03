package com.store.utils.jwt;

import java.util.List;

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

    /**
     * 获取登陆用户角色类型
     * @return
     */
    List<String> getRoleTypes();

}
