package com.store.utils;

import cn.hutool.core.lang.Validator;
import cn.hutool.log.LogFactory;
import cn.hutool.system.OsInfo;
import com.store.constants.CommonConstants;
import com.store.utils.jwt.IJWTInfo;
import com.store.utils.jwt.JWTHelper;

/**
 * Created by ace on 2017/9/10.
 */
public class JWTTokenUtil {
    private String priKey;
    private String pubKey;
    private OsInfo osInfo;
    private static JWTTokenUtil jwtTokenUtil;
    private JWTTokenUtil(){
        if (Validator.isNull(osInfo)){
            osInfo = new OsInfo();
        }
//        priKey = osInfo.isWindows() ? CommonConstants.JWT_PRI_KEY_PATH_WIN : CommonConstants.JWT_PRI_KEY_PATH_LINUX;
//        pubKey = osInfo.isWindows() ? CommonConstants.JWT_PUB_KEY_PATH_WIN : CommonConstants.JWT_PUB_KEY_PATH_LINUX;
        priKey = CommonConstants.JWT_PRI_KEY_PATH_WIN;
        pubKey =  CommonConstants.JWT_PUB_KEY_PATH_WIN;
    }
    public static JWTTokenUtil Singleton(){
        if (Validator.isNull(jwtTokenUtil)) {
            jwtTokenUtil = new JWTTokenUtil();
        }
        return jwtTokenUtil;
    }
    public String generateToken(IJWTInfo jwtInfo) throws Exception {
        LogFactory.get().info(" JWT generateToken start...");
        return JWTHelper.generateToken(jwtInfo,priKey, CommonConstants.JWT_ACCESS_EXPIRE);
    }

    public IJWTInfo getInfoFromToken(String token) throws Exception {
        LogFactory.get().info(" JWT getInfoFromToken start...");
        return JWTHelper.getInfoFromToken(token, pubKey);
    }


}
