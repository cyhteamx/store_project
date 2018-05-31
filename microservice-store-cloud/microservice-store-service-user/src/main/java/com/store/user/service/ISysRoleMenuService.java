package com.store.user.service;


import com.baomidou.mybatisplus.service.IService;
import com.store.model.SysRoleMenu;

/**
 * 角色菜单表 服务类
 *
 * @author chenyouhong
 * @since 2018-05-09
 */
public interface ISysRoleMenuService extends IService<SysRoleMenu> {

    /**
     * 更新角色菜单
     *
     *
     * @param role
     * @param roleId  角色
     * @param menuIds 菜单列表
     * @return
     */
    Boolean insertRoleMenus(Integer role, Integer roleId, Integer[] menuIds);
}
