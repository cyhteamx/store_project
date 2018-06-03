package com.store.utils;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.store.constants.CommonConstants;
import com.store.utils.jwt.IJWTInfo;
import com.store.utils.jwt.JWTInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.List;

/**
 * @author chenyouhong
 * @since 2018-05-19
 *
 * 用户相关工具类
 */
@Slf4j
public class UserUtils {

    private static final ThreadLocal<String> THREAD_LOCAL_USER = new TransmittableThreadLocal<>();

    private static final String KEY_USER = "user";

    /**
     * 根据请求heard中的token获取登录用户名
     *
     * @param httpServletRequest request
     * @return 登录用户名
     */
    public static JWTInfo getUserinfo(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader(CommonConstants.JWT_ACCESS_TOKEN);
        JWTInfo jwtInfo = null;
        if (!StringUtils.isBlank(token)) {
            try {
                IJWTInfo ijwtInfo = JWTTokenUtil.Singleton().getInfoFromToken(token);
                log.info("检验登录access-token成功，当前登录人员为：{}", ijwtInfo.getName());
                jwtInfo = new JWTInfo(ijwtInfo.getLoginName(), ijwtInfo.getId(), ijwtInfo.getName(), ijwtInfo.getRoleTypes());
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return jwtInfo;
    }

    /**
     * 根据请求heard中的token获取登录用户名
     *
     * @param httpServletRequest request
     * @return 登录用户名
     */
    public static String getUserName(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader(CommonConstants.JWT_ACCESS_TOKEN);
        String userName = null;
        if (!StringUtils.isBlank(token)) {
            try {
                IJWTInfo ijwtInfo = JWTTokenUtil.Singleton().getInfoFromToken(token);
                log.info("检验登录access-token成功，当前登录人员为：{}", ijwtInfo.getName());
                userName = ijwtInfo.getName();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return userName;
    }

    /**
     * 根据请求heard中的token获取用户角色
     *
     * @param httpServletRequest request
     * @return 角色名
     */
    public static List<String> getRole(HttpServletRequest httpServletRequest) {
        String token = getToken(httpServletRequest);
        String key = Base64.getEncoder().encodeToString(CommonConstants.SIGN_KEY.getBytes());
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        List<String> roleNames = (List<String>) claims.get("authorities");
        return roleNames;
    }

    /**
     * 获取请求中token
     *
     * @param httpServletRequest request
     * @return token
     */
    public static String getToken(HttpServletRequest httpServletRequest) {
        String authorization = httpServletRequest.getHeader(CommonConstants.REQ_HEADER);
        return StringUtils.substringAfter(authorization, CommonConstants.TOKEN_SPLIT);
    }

    /**
     * 设置用户信息
     *
     * @param username 用户名
     */
    public static void setUser(String username) {
        THREAD_LOCAL_USER.set(username);
        MDC.put(KEY_USER, username);
    }

    /**
     * 从threadlocal 获取用户名
     *
     * @return 用户名
     */

    public static String getUser() {
        return THREAD_LOCAL_USER.get();
    }

    /**
     * 如果没有登录，返回null
     *
     * @return 用户名
     */
    public static String getUserName() {
        return THREAD_LOCAL_USER.get();
    }

    public static void clearAllUserInfo() {
        THREAD_LOCAL_USER.remove();
        MDC.remove(KEY_USER);
    }
}
