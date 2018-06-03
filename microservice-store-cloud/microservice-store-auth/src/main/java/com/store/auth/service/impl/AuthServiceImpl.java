package com.store.auth.service.impl;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Validator;
import com.store.auth.props.MyProps;
import com.store.auth.service.IAuthService;
import com.store.auth.service.IUserService;
import com.store.exception.auth.ClientInvalidException;
import com.store.exception.auth.UserInvalidException;
import com.store.utils.jwt.IJWTInfo;
import com.store.utils.jwt.JWTInfo;
import com.store.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * AuthServiceImpl.class
 * Description:
 *
 * @author Carter
 * @date 2018/06/03
 */
@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private MyProps myProps;

    @Autowired
    private IUserService userService;

    @Override
    public IJWTInfo authByLogin(String loginName, String passwd) {
        // 登录白名单
        List<Map<String, String>> jwtWhiteList = myProps.getJwtWhiteList();
        if (CollUtil.isNotEmpty(jwtWhiteList)) {
            if (jwtWhiteList.stream().anyMatch(
                    j ->
                            Validator.equal(loginName, j.get("loginname"))
                                    && Validator.equal(passwd, j.get("passwd")))) {
                JWTInfo jwtInfo = new JWTInfo("admin", "1", "admin");
                ResultVO<List<String>> result = userService.findRoletypeByUsername(jwtInfo.getName());
                jwtInfo.setRoleTypes(result.getData());
                return jwtInfo;
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
                JWTInfo jwtInfo = new JWTInfo(serviceId, serviceId, serviceId);
                ResultVO<List<String>> result = userService.findRoletypeByUsername(jwtInfo.getName());
                jwtInfo.setRoleTypes(result.getData());
                return new JWTInfo(serviceId, serviceId, serviceId);
            }
        }
        throw new ClientInvalidException();
    }

}
