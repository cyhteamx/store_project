package com.store.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author chenyouhong
 * @since 2018-05-09
 */
@Data
public class UserVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 随机盐
     */
    private String salt;

    /**
     * 密码
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 部门ID
     */
    private Integer deptId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 删除标记
     */
    private int delFlag;

    /**
     * 角色列表
     */
    private List<SysRole> roleList;

}
