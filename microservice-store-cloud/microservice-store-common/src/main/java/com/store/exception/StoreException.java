package com.store.exception;

import com.store.enums.ResultEnum;
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
