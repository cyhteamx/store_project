package com.store.user.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.store.constants.CommonConstants;
import com.store.dto.MenuDTO;
import com.store.mapper.ISysMenuMapper;
import com.store.model.SysMenu;
import com.store.user.converter.SysMenu2MenuDTOConverter;
import com.store.user.dto.MenuTree;
import com.store.user.service.ISysMenuService;
import com.store.user.util.TreeUtil;
import com.store.vo.MenuVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 菜单权限表 服务实现类
 *
 * @author chenyouhong
 * @since 2018-05-19
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<ISysMenuMapper, SysMenu> implements ISysMenuService {

    @Autowired
    private ISysMenuMapper sysMenuMapper;

    @Override
    @Cacheable(value = "menu_details", key = "#role  + '_menu'")
    public List<MenuVO> findMenuByRoleName(String role) {
        return sysMenuMapper.findMenuByRoleName(role);
    }

    @Override
    public List<MenuDTO> findMenuByUserName(String userName) {
        List<SysMenu> menus = sysMenuMapper.findMenuByUserName(userName);
        List<MenuDTO> menuDTOList = SysMenu2MenuDTOConverter.convert(menus);
        return menuDTOList;
    }

    @Override
    @Cacheable(value = "menu_details", key = "#role  + '_menu'")
    public List<MenuVO> findMenuByRole(String role) {
        return sysMenuMapper.findMenuByRoleName(role);
    }

    @Override
    public String[] findPermission(String[] roles) {
        Set<MenuVO> menuVoSet = new HashSet<>();
        for (String role : roles) {
            List<MenuVO> menuVos = findMenuByRole(role);
            menuVoSet.addAll(menuVos);
        }

        Set<String> permissions = new HashSet<>();
        for (MenuVO menuVo : menuVoSet) {
            if (StringUtils.isNotEmpty(menuVo.getPermission())) {
                String permission = menuVo.getPermission();
                permissions.add(permission);
            }
        }

        return permissions.toArray(new String[permissions.size()]);
    }

    @Override
    @CacheEvict(value = "menu_details", key = "#role + '_menu'")
    public Boolean deleteMenu(Integer id, String role) {
       // Assert.isNull(id, "菜单ID不能为空");
        // 删除当前节点
        SysMenu condition1 = new SysMenu();
        condition1.setId(id);
        condition1.setDelFlag(CommonConstants.STATUS_DEL);
        this.updateById(condition1);

        // 删除父节点为当前节点的节点
        SysMenu conditon2 = new SysMenu();
        conditon2.setParentId(id);
        SysMenu sysMenu = new SysMenu();
        sysMenu.setDelFlag(CommonConstants.STATUS_DEL);
        return this.update(sysMenu, new EntityWrapper<>(conditon2));
    }

    @Override
    @CacheEvict(value = "menu_details", key = "#role + '_menu'")
    public Boolean updateMenuById(SysMenu sysMenu, String role) {
        return this.updateById(sysMenu);
    }

    /**
     * 返回角色的菜单
     *
     * @param roleName 角色
     * @return 菜单列表
     */
    @Override
    public List<MenuTree> findUserMenuTree(String roleName) {
        // 获取符合条件得菜单
        List<MenuVO> all = findMenuByRole(roleName);
        final List<MenuTree> menuTreeList = new ArrayList<>();
        all.forEach((menuVo -> {
            if (CommonConstants.MENU.equals(menuVo.getType())) {
                menuTreeList.add(new MenuTree(menuVo));
            }
        }));
        return TreeUtil.bulid(menuTreeList, -1);
    }

    /**
     * 返回角色的菜单
     *
     * @param roleNames 角色
     * @return 菜单列表
     */
    @Override
    public List<MenuTree> findUserMenuTree(List<String> roleNames) {
        // 获取符合条件得菜单
        Set<MenuVO> all = new HashSet<>();
        roleNames.forEach(roleName -> all.addAll(findMenuByRoleName(roleName)));
        List<MenuTree> menuTreeList = new ArrayList<>();
        all.forEach(menuVo -> {
            if (CommonConstants.MENU == menuVo.getType()) {
                menuTreeList.add(new MenuTree(menuVo));
            }
        });
        CollUtil.sort(menuTreeList, Comparator.comparingInt(MenuTree::getSort));
        return TreeUtil.bulid(menuTreeList, 0);
    }

}
