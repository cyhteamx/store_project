package com.store.user.service;


import com.baomidou.mybatisplus.service.IService;
import com.store.model.SysUserRole;

/**
 * 用户角色表 服务类
 *
 * @author chenyouhong
 * @since 2018-05-09
 */
public interface ISysUserRoleService extends IService<SysUserRole> {

    /**
     * 根据用户Id删除该用户的角色关系
     *
     * @author 寻欢·李
     * @date 2017年12月7日 16:31:38
     * @param userId 用户ID
     * @return boolean
     */
    Boolean deleteByUserId(Integer userId);
}
