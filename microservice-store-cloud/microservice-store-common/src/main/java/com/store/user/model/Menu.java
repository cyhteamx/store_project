package com.store.user.model;

import lombok.Data;

import java.util.Date;

@Data
public class Menu {

    /** 菜单ID. */
    private Integer menuId;

    /** 菜单名称. */
    private String name;

    /** 菜单URL. */
    private String url;

    /** 序号. */
    private String number;

    /** 是否叶子节点:0父节点,1叶节点. */
    private Integer isleaf;

    /** 层级:一级菜单,二级菜单,三级菜单. */
    private Integer level;

    /** 父节点:一级菜单为0. */
    private Integer parentId;

    /** 菜单icon. */
    private String icon;

    /** 创建时间. */
    private Date createTime;

    /** 更新时间. */
    private Date updateTime;

}
