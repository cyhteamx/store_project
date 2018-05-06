package com.store.exception.auth;

import com.store.constants.CommonConstants;
import com.store.exception.BaseException;

/**
 * Created by ace on 2017/9/10.
 */
public class UserInvalidException extends BaseException {
    public UserInvalidException() {
        super(CommonConstants.EX_USER_INVALID_MSG, CommonConstants.EX_USER_INVALID_CODE);
    }
}
