package com.store.service;

//import admin.api.authority.PermissionInfo;
//import admin.api.log.LogInfo;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.exceptions.ValidateException;
import cn.hutool.core.lang.Validator;
import com.store.config.WhiteListConfig;
//import common.util.jwt.IJWTInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * AccessService.class
 * Description:
 *
 * @author lupo
 * @date 2018/2/14 9:11
 */
@Component
@Slf4j
public class AccessService {

    @Autowired
    private WhiteListConfig whiteListConfig;

    /**
     * 白名单验证
     *
     * @param requestURI 请求的URI
     * @return
     */
    public boolean ignoreUri(String requestURI) throws ValidateException {
        boolean flag = false;
        Validator.validateNotEmpty(requestURI, "请求的URI不能为空");
        List<String> uriWhiteList = whiteListConfig.getUriWhiteList();
        if (CollUtil.isNotEmpty(uriWhiteList)) {
            flag = uriWhiteList.parallelStream().anyMatch(u ->
                    Validator.equal(requestURI, u) || requestURI.startsWith(u)
            );
        }
        return flag;
    }

    /**
     *
     * @param requestURI
     * @param method
     * @param allPermissions
     * @return
     */
//    public List<PermissionInfo> getPermissionIfs(String requestURI, String method, List<PermissionInfo> allPermissions) {
//        Stream<PermissionInfo> stream = allPermissions.parallelStream().filter(permissionInfo -> {
//            String url = permissionInfo.getUri();
//            String uri = url.replaceAll("\\{\\*\\}", "[a-zA-Z\\\\d]+");
//            String regEx = "^" + uri + "$";
//            return (Pattern.compile(regEx).matcher(requestURI).find() || requestURI.startsWith(url + "/"))
//                    && method.equals(permissionInfo.getMethod());
//        });
//
//        return stream.collect(Collectors.toList());
//    }
//
//    /**
//     * @param result
//     * @param userPermissions
//     */
//    public PermissionInfo checkUserPermission(List<PermissionInfo> result, List<PermissionInfo> userPermissions) throws ValidateException {
//        PermissionInfo current = null;
//        for (PermissionInfo info : result) {
//            if (userPermissions.parallelStream().anyMatch(u -> u.getCode().equalsIgnoreCase(info.getCode()))) {
//                current = info;
//                break;
//            }
//        }
//        return Validator.validateNotNull(current,"Token Forbidden!");
//    }
}
