package com.store.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜单权限表
 *
 * @author chenyouhong
 * @since 2018-05-09
 */
@Data
@TableName("tb_sys_menu")
public class SysMenu extends Model<SysMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
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
	@TableField("parent_id")
	private Integer parentId;

    /**
     * 图标
     */
	private String icon;

	/**
	 * VUE页面
	 */
	private String component;

	/**
	 * 前端URL
	 */
	private String path;

    /**
     * 菜单类型 （0菜单 1按钮）
     */
	private Integer type;

	/**
	 * 0--正常 1--删除
	 */
	@TableField("del_flag")
	private Integer delFlag;

    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;

    /**
     * 更新时间
     */
	@TableField("update_time")
	private Date updateTime;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
