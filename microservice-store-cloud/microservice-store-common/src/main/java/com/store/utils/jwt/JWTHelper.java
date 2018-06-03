package com.store.utils.jwt;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.StrUtil;
import com.store.constants.CommonConstants;
import com.store.utils.KeyHelper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.List;


/**
 * Created by ace on 2017/9/10.
 */
public class JWTHelper {
    /**
     * 密钥加密token
     *
     * @param jwtInfo
     * @param priKeyPath
     * @param expire
     * @return
     * @throws Exception
     */
    public static String generateToken(IJWTInfo jwtInfo, String priKeyPath, int expire) throws Exception {
        String compactJws = Jwts.builder()
                .setSubject(jwtInfo.getLoginName())
                .claim(CommonConstants.JWT_KEY_USER_ID, jwtInfo.getId())
                .claim(CommonConstants.JWT_KEY_NAME, jwtInfo.getName())
                .claim(CommonConstants.JWT_KEY_ROLETYPE, jwtInfo.getRoleTypes())
                .setExpiration(DateTime.now().offset(DateField.MINUTE,expire))
                .signWith(SignatureAlgorithm.RS256, KeyHelper.getPrivateKey(priKeyPath))
                .compact();
        return compactJws;
    }

    /**
     * 公钥解析token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Jws<Claims> parserToken(String token, String pubKeyPath) throws Exception {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(KeyHelper.getPublicKey(pubKeyPath)).parseClaimsJws(token);
        return claimsJws;
    }

    /**
     * 获取token中的用户信息
     *
     * @param token
     * @param pubKeyPath
     * @return
     * @throws Exception
     */
    public static IJWTInfo getInfoFromToken(String token, String pubKeyPath) throws Exception {
        Jws<Claims> claimsJws = parserToken(token, pubKeyPath);
        Claims body = claimsJws.getBody();
        JWTInfo info = new JWTInfo(body.getSubject(), StrUtil.nullToDefault((CharSequence) body.get(CommonConstants.JWT_KEY_USER_ID),""), StrUtil.nullToDefault((CharSequence) body.get(CommonConstants.JWT_KEY_NAME),""));
        System.out.println(body.get(CommonConstants.JWT_KEY_ROLETYPE).getClass());
//        StrUtil.split(body.get(CommonConstants.JWT_KEY_ROLETYPE), "");
        info.setRoleTypes((List<String>)body.get(CommonConstants.JWT_KEY_ROLETYPE));
//        String str = StrUtil.nullToDefault((CharSequence) body.get(CommonConstants.JWT_KEY_NAME),"");
//        info.setRoleTypes(str.toCharArray());
        return info;
        //        return new JWTInfo(body.getSubject(), StrUtil.nullToDefault((CharSequence) body.get(CommonConstants.JWT_KEY_USER_ID),""), StrUtil.nullToDefault((CharSequence) body.get(CommonConstants.JWT_KEY_NAME),""));
    }

}
