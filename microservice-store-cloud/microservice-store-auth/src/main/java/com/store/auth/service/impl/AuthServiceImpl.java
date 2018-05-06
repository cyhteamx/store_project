package com.store.auth.service.impl;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Validator;
import com.store.auth.props.MyProps;
import com.store.auth.service.IAuthService;
import com.store.exception.auth.ClientInvalidException;
import com.store.exception.auth.UserInvalidException;
import com.store.utils.jwt.IJWTInfo;
import com.store.utils.jwt.JWTInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * AuthServiceImpl.class
 * Description:
 *
 * @author Carter
 * @date 2018/5/6 10:01
 */
@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private MyProps myProps;
    @Override
    public IJWTInfo authByLogin(String loginName, String passwd) {
        // 登录白名单
        List<Map<String, String>> jwtWhiteList = myProps.getJwtWhiteList();
        if (CollUtil.isNotEmpty(jwtWhiteList)) {
            if (jwtWhiteList.stream().anyMatch(
                    j ->
                            Validator.equal(loginName, j.get("loginname"))
                                    && Validator.equal(passwd, j.get("passwd")))) {
                return new JWTInfo("admin", "1", "admin");
            }
        }
        throw new UserInvalidException();
    }

    @Override
    public IJWTInfo authByService(String serviceId, String secret) {
        // 服务白名单
        List<Map<String, String>> clientWhiteList = myProps.getClientWhiteList();
        if (CollUtil.isNotEmpty(clientWhiteList)) {
            if (clientWhiteList.stream().anyMatch(
                    c ->
                            Validator.equal(serviceId, c.get("serviceid"))
                                    && Validator.equal(secret, c.get("secret")))) {
                return new JWTInfo(serviceId, serviceId, serviceId);
            }
        }
        throw new ClientInvalidException();
    }

}
