package com.store.vo;


import com.store.constants.CommonConstants;

/**
 * Created by ace on 2017/8/23.
 */
public class BaseResponse {
    private int status = CommonConstants.RESPONSE_SUCCESS;
    private String message = CommonConstants.RESPONSE_SUCCESS_MSG;

    public BaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
