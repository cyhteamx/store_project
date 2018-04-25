package com.store.user.enums;

import lombok.Getter;

@Getter
public enum MenuLevelEnum implements CodeEnum {

    ONELEVEL(1, "一级菜单"),
    TWOLEVEL(2, "二级菜单"),
    THREELEVEL(3, "三级菜单");

    private Integer code;

    private String message;

    MenuLevelEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
