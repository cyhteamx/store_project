package com.store.user.dto;

import com.store.model.SysRole;
import lombok.Data;

/**
 * @author chenyouhong
 * @since 2018-05-19
 *
 * 角色Dto
 */
@Data
public class RoleDTO extends SysRole {
    /**
     * 角色部门Id
     */
    private Integer roleDeptId;

    /**
     * 部门名称
     */
    private String deptName;

}
