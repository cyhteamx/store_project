package com.store.user.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.store.constants.CommonConstants;
import com.store.dto.MenuDTO;
import com.store.model.SysMenu;
import com.store.user.dto.MenuTree;
import com.store.user.service.ISysMenuService;
import com.store.user.util.TreeUtil;
import com.store.utils.R;
import com.store.utils.ResultVOUtil;
import com.store.vo.MenuVO;
import com.store.vo.ResultVO;
import com.store.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyouhong
 * @since 2018-05-19
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {

    @Autowired
    private ISysMenuService sysMenuService;

    /**
     * 返回当前用户的树形菜单集合
     * @return 当前用户的树形菜单
     */
    @GetMapping(value = "/findMenuByUserName")
    public ResultVO<List<MenuDTO>> findMenuByUserName(){
        String userName = getUserName();
        return ResultVOUtil.success(sysMenuService.findMenuByUserName(userName));
    }

    /**
     * 通过用户名查询用户菜单
     *
     * @param role 角色名称
     * @return 菜单列表
     */
    @GetMapping("/findMenuByRole/{role}")
    public List<MenuVO> findMenuByRole(@PathVariable String role) {
        return sysMenuService.findMenuByRole(role);
    }

    /**
     * 返回当前用户的树形菜单集合
     * @return 当前用户的树形菜单
     */
    @GetMapping(value = "/userMenu")
    public List<MenuTree> userMenu(){
//        return sysMenuService.findUserMenuTree(getUserinfo().getRoleTypes());
        return sysMenuService.findUserMenuTree(getRole());
    }

    /**
     * 返回树形菜单集合
     *
     * @return 树形菜单
     */
    @GetMapping(value = "/allTree")
    public List<MenuTree> getAllTree() {
        SysMenu condition = new SysMenu();
        condition.setDelFlag(CommonConstants.STATUS_NORMAL);
        return getMenuTree(sysMenuService.selectList(new EntityWrapper<>(condition)), 0);
    }

    /**
     * 返回树形菜单集合
     *
     * @return 树形菜单
     */
    @GetMapping(value = "/tree")
    public List<MenuTree> getTree() {
        SysMenu condition = new SysMenu();
        //condition.setDelFlag(CommonConstant.STATUS_NORMAL);
        return getMenuTree(sysMenuService.selectList(new EntityWrapper<>(condition)), -1);
    }

    /**
     * 返回当前用户的树形菜单集合
     * @return 当前用户的树形菜单
     */
    @GetMapping(value = "/getUserTree")
    public List<MenuTree> getUserTree(){
        return sysMenuService.findUserMenuTree(getRole().get(0));
    }

    /**
     * 返回当前用户树形菜单集合
     *
     * @return 树形菜单
     */
    @GetMapping("/userTree")
    public List<Integer> userTree() {
        List<MenuVO> menus = sysMenuService.findMenuByRole(getRole().get(0));
        List<Integer> menuList = new ArrayList<>();
        for (MenuVO menuVo : menus) {
            menuList.add(menuVo.getId());
        }
        return menuList;
    }

    /**
     * 返回角色的菜单集合
     *
     * @param roleName 角色名称
     * @return 属性集合
     */
    @GetMapping("/roleTree/{roleName}")
    public List<Integer> roleTree(@PathVariable String roleName) {
        List<MenuVO> menus = sysMenuService.findMenuByRole(roleName);
        List<Integer> menuList = new ArrayList<>();
        for (MenuVO menuVo : menus) {
            menuList.add(menuVo.getId());
        }
        return menuList;
    }

    /**
     * 通过ID查询菜单的详细信息
     *
     * @param id 菜单ID
     * @return 菜单详细信息
     */
    @GetMapping("/{id}")
    public SysMenu menu(@PathVariable Integer id) {
        return sysMenuService.selectById(id);
    }

    /**
     * 新增菜单
     *
     * @param sysMenu 菜单信息
     * @return success/false
     */
    @PostMapping
    public R<Boolean> menu(@RequestBody SysMenu sysMenu) {
        return new R<>(sysMenuService.insert(sysMenu));
    }

    /**
     * 删除菜单
     *
     * @param id 菜单ID
     * @return success/false
     * TODO  级联删除下级节点
     */
    @DeleteMapping("/{id}")
    public R<Boolean> menuDel(@PathVariable Integer id) {
        return new R<>(sysMenuService.deleteMenu(id,getRole().get(0)));
    }

    @PutMapping
    public R<Boolean> menuUpdate(@RequestBody SysMenu sysMenu) {
        return new R<>(sysMenuService.updateMenuById(sysMenu, getUserinfo().getRoleTypes().get(0)));
    }

    private List<MenuTree> getMenuTree(List<SysMenu> menus, int root) {
        List<MenuTree> trees = new ArrayList<MenuTree>();
        MenuTree node = null;
        for (SysMenu menu : menus) {
            node = new MenuTree();
            node.setId(menu.getId());
            node.setParentId(menu.getParentId());
            node.setName(menu.getName());
            node.setUrl(menu.getUrl());
            node.setLabel(menu.getName());
            node.setIcon(menu.getIcon());
            trees.add(node);
        }
        return TreeUtil.bulid(trees, root);
    }
}
