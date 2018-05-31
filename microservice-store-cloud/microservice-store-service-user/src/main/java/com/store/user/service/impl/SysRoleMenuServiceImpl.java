package com.store.user.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.store.mapper.ISysRoleMenuMapper;
import com.store.model.SysRoleMenu;
import com.store.user.service.ISysRoleMenuService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色菜单表 服务实现类
 *
 * @author chenyouhong
 * @since 2018-05-19
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<ISysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {
    @Override
    @CacheEvict(value = "menu_details", key = "#role + '_menu'")
    public Boolean insertRoleMenus(Integer role, Integer roleId, Integer[] menuIds) {
        SysRoleMenu condition = new SysRoleMenu();
        condition.setRoleId(roleId);
        this.delete(new EntityWrapper<>(condition));

        List<SysRoleMenu> roleMenuList = new ArrayList<>();
        for (Integer menuId : menuIds) {
            SysRoleMenu roleMenu = new SysRoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(menuId);
            roleMenuList.add(roleMenu);
        }
        return this.insertBatch(roleMenuList);
    }
}
