package com.store.exception.auth;

import com.store.constants.CommonConstants;
import com.store.exception.BaseException;

/**
 * Created by ace on 2017/9/10.
 */
public class ClientInvalidException extends BaseException {
    public ClientInvalidException() {
        super(CommonConstants.EX_CLIENT_INVALID_MSG, CommonConstants.EX_CLIENT_INVALID_CODE);
    }
}
