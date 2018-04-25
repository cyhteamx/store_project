package com.store.user.exception;

import com.store.user.enums.ResultEnum;
import lombok.Getter;

@Getter
public class StoreException extends RuntimeException {

    private Integer code;

    public StoreException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public StoreException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
