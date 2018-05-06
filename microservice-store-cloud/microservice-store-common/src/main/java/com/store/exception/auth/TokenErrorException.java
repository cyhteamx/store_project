package com.store.exception.auth;

import com.store.constants.CommonConstants;
import com.store.exception.BaseException;

/**
 * Created by ace on 2017/9/8.
 */
public class TokenErrorException extends BaseException {
    public TokenErrorException() {
        super(CommonConstants.EX_TOKEN_ERROR_MSG, CommonConstants.EX_TOKEN_ERROR_CODE);
    }
}
