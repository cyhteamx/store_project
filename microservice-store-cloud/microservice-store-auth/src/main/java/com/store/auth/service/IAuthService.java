package com.store.auth.service;


import com.store.utils.jwt.IJWTInfo;

/**
 * AuthService.class
 * Description:
 *
 */
public interface IAuthService {

    IJWTInfo authByLogin(String loginName, String passwd);


    IJWTInfo authByService(String serviceId, String secret);
}
