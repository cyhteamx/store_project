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
public class ClientTokenUtil {
    private OsInfo osInfo;
    private static ClientTokenUtil clientTokenUtil;
    private String prikey;
    private String pubkey;
    private ClientTokenUtil(){
        if (Validator.isNull(osInfo)) {
            osInfo = new OsInfo();
        }
//        prikey = osInfo.isWindows()? CommonConstants.CLIENT_PRI_KEY_PATH_WIN : CommonConstants.CLIENT_PRI_KEY_PATH_LINUX;
//        pubkey = osInfo.isWindows()? CommonConstants.CLIENT_PUB_KEY_PATH_WIN : CommonConstants.CLIENT_PUB_KEY_PATH_LINUX;
        prikey = CommonConstants.CLIENT_PRI_KEY_PATH_WIN;
        pubkey = CommonConstants.CLIENT_PUB_KEY_PATH_WIN;
    }
    public static ClientTokenUtil Singleton(){
        if (Validator.isNull(clientTokenUtil)){
            clientTokenUtil = new ClientTokenUtil();
        }
        return clientTokenUtil;
    }


    public String generateToken(IJWTInfo jwtInfo) throws Exception {
        LogFactory.get().info(" client generateToken start...");
        return JWTHelper.generateToken(jwtInfo,prikey, CommonConstants.CLIENT_ACCESS_EXPIRE);
    }

    public IJWTInfo getInfoFromToken(String token) throws Exception {
        LogFactory.get().info(" client getInfoFromToken start...");
        return JWTHelper.getInfoFromToken(token,pubkey);
    }

}
