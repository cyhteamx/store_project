package com.store.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.store.model.SysUserRole;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
  * 用户角色表 Mapper 接口
 * </p>
 *
 * @author chenyouhong
 * @since 2018-05-09
 */
public interface ISysUserRoleMapper extends BaseMapper<SysUserRole> {

    /**
     * 根据用户Id删除该用户的角色关系
     *
     * @param userId 用户ID
     * @return boolean
     * @date  2018-05-09
     */
    Boolean deleteByUserId(@Param("userId") Integer userId);

}