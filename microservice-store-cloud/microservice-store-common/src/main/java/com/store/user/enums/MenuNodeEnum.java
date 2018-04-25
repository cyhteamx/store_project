package com.store.user.enums;

import lombok.Getter;

@Getter
public enum MenuNodeEnum implements CodeEnum {

    PARENTNODE(0, "父节点"),
    LEAFNODE(1, "叶节点");

    private Integer code;

    private String message;

    MenuNodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
