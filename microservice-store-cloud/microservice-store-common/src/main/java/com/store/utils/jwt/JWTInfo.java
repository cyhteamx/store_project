package com.store.utils.jwt;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chenyouhng on 2018/6/3.
 */
@Data
public class JWTInfo implements Serializable,IJWTInfo {

    private String loginName;

    private String userId;

    private String name;

    private List<String> roleTypes;

    public JWTInfo(String loginName, String userId, String name) {
        this.loginName = loginName;
        this.userId = userId;
        this.name = name;
    }

    public JWTInfo(String loginName, String userId, String name, List<String> roleTypes) {
        this.loginName = loginName;
        this.userId = userId;
        this.name = name;
        this.roleTypes = roleTypes;
    }

//    public String getLoginName() {
//        return loginName;
//    }
//
//    public void setLoginName(String loginName) {
//        this.loginName = loginName;
//    }

    public String getId() {
        return userId;
    }

//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JWTInfo jwtInfo = (JWTInfo) o;

        if (loginName != null ? !loginName.equals(jwtInfo.loginName) : jwtInfo.loginName != null) return false;
        return userId != null ? userId.equals(jwtInfo.userId) : jwtInfo.userId == null;

    }

    @Override
    public int hashCode() {
        int result = loginName != null ? loginName.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
