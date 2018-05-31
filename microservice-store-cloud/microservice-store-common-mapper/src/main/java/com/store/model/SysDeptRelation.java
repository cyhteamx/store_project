package com.store.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 *
 *
 * @author chenyouhong
 * @since 2018-05-09
 */
@Data
@TableName("tb_sys_dept_relation")
public class SysDeptRelation extends Model<SysDeptRelation> {

    private static final long serialVersionUID = 1L;

    /**
     * 祖先节点
     */
	private Integer ancestor;

    /**
     * 后代节点
     */
	private Integer descendant;

	@Override
	protected Serializable pkVal() {
		return this.ancestor;
	}

}
