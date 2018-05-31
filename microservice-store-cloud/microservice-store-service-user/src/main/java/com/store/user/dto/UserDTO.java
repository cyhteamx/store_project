package com.store.user.dto;

import com.store.model.SysUser;
import lombok.Data;

/**
 * @author chenyouhong
 * @since 2018-05-19
 *
 */
@Data
public class UserDTO extends SysUser {

    /**
     * 角色ID
     */
    private Integer role;

    private Integer deptId;

    /**
     * 新密码
     */
    private String newpassword1;

}
