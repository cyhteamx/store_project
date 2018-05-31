package com.store.user.service;


import com.baomidou.mybatisplus.service.IService;
import com.store.dto.MenuDTO;
import com.store.model.SysMenu;
import com.store.user.dto.MenuTree;
import com.store.vo.MenuVO;

import java.util.List;

/**
 * 菜单权限表 服务类
 *
 * @author chenyouhong
 * @since 2018-05-09
 */
public interface ISysMenuService extends IService<SysMenu> {

    /**
     * 通过角色名称查询URL 权限
     *
     * @param role 角色名称
     * @return 菜单列表
     */
    List<MenuVO> findMenuByRoleName(String role);

    /**
     * 查询当前用户登录的菜单
     * @param userName
     * @return
     */
    List<MenuDTO> findMenuByUserName(String userName);

    /**
     * 通过角色名称查询URL 权限
     *
     * @param role 角色名称
     * @return 菜单列表
     */
    List<MenuVO> findMenuByRole(String role);

    /**
     * 通过角色获取菜单权限列表
     *
     * @param roles 角色
     * @return 权限列表
     */
    String[] findPermission(String[] roles);

    /**
     * 级联删除菜单
     *
     * @param id   菜单ID
     * @param role 角色
     * @return 成功、失败
     */
    Boolean deleteMenu(Integer id, String role);

    /**
     * 更新菜单信息
     *
     * @param sysMenu 菜单信息
     * @param role    角色
     * @return 成功、失败
     */
    Boolean updateMenuById(SysMenu sysMenu, String role);

    /**
     * 返回角色的菜单
     * @param roleName 角色
     * @return 菜单列表
     */
    List<MenuTree> findUserMenuTree(String roleName);

    /**
     * 返回角色的菜单
     * @param roleNames 角色
     * @return 菜单列表
     */
    List<MenuTree> findUserMenuTree(List<String> roleNames);

}
