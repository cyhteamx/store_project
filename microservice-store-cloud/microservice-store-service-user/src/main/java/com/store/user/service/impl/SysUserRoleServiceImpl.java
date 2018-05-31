package com.store.user.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.store.mapper.ISysUserRoleMapper;
import com.store.model.SysUserRole;
import com.store.user.service.ISysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * 用户角色表 服务实现类
 *
 * @author chenyouhong
 * @since 2018-05-09
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<ISysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

    /**
     * 根据用户Id删除该用户的角色关系
     *
     * @param userId 用户ID
     * @return boolean
     * @author 寻欢·李
     * @date 2017年12月7日 16:31:38
     */
    @Override
    public Boolean deleteByUserId(Integer userId) {
        return baseMapper.deleteByUserId(userId);
    }
}
