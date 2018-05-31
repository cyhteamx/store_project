package com.store.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.store.model.SysDept;

import java.util.List;

/**
 * 部门管理 Mapper 接口
 *
 * @author chenyouhong
 * @since 2018-05-19
 */
public interface ISysDeptMapper extends BaseMapper<SysDept> {

    /**
     * 关联dept——relation
     *
     * @param delFlag 删除标记
     * @return 数据列表
     */
    List<SysDept> selectDeptDtoList(Integer delFlag);

    /**
     * 删除部门关系表数据
     * @param id 部门ID
     */
    void deleteDeptRealtion(Integer id);
}