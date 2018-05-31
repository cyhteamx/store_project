package com.store.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户角色表
 *
 * @author chenyouhong
 * @since 2018-05-09
 */
@Data
@TableName("tb_sys_user_role")
public class SysUserRole extends Model<SysUserRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(type = IdType.INPUT)
	private Integer userId;
    /**
     * 角色ID
     */
	@TableId(type = IdType.INPUT)
	private Integer roleId;

	@Override
	protected Serializable pkVal() {
		return this.userId;
	}

}
