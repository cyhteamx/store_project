package com.store.vo;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author chenyouhong
 * @since 2018-05-19
 */
@Data
public class SysRole implements Serializable {

    private static final long serialVersionUID = 3751825094664982312L;

    private Integer id;

    private String roleName;

    private String roleType;

    private String roleDesc;

}
