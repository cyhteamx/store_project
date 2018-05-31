package com.store.web;

import com.store.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author chenyouhong
 * @since 2018-05-19
 */
public class BaseController {

    @Autowired
    private HttpServletRequest request;

    /**
     * 根据请求heard中的token获取用户角色
     *
     * @return 角色名
     */
    public List<String> getRole() {
        return UserUtils.getRole(request);
    }

    /**
     * 根据请求heard中的token获取登录用户名
     *
     * @return 登录用户名
     */
    public String getUserName() {
        return UserUtils.getUserName(request);
    }

}
