package com.store.auth.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 */
@Data
public class JwtAuthenticationVo implements Serializable {

    private String loginname;

    private String password;

}
