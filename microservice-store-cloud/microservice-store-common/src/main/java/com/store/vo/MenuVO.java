package com.store.vo;

import lombok.Data;

import java.util.Date;

/**
 * 菜单权限表
 *
 * @author chenyouhong
 * @since 2018-05-19
 */
@Data
public class MenuVO {

    /**
     * 菜单ID
     */
    private Integer id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单权限标识
     */
    private String permission;

    /**
     * 请求链接
     */
    private String url;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 一个路径
     */
    private String path;

    /**
     * VUE页面
     */
    private String component;

    /**
     * 排序值
     */
    private Integer sort;

    /**
     * 是否下级节点ISLEAF, 是否叶子节点:0父节点,1叶节点
     */
    private boolean isLeaf;

    /**
     * 层级:一级菜单,二级菜单,三级菜单
     */
    private Integer level;

    /**
     * 父菜单ID,父节点:一级菜单为0
     */
    private Integer parentId;

    /**
     * 图标
     */
    private String icon;

    /**
     * 菜单类型 （0菜单 1按钮）
     */
    private Integer type;

    /**
     * 0--正常 1--删除
     */
    private Integer delFlag;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
