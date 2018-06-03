package com.store.user.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.store.constants.CommonConstants;
import com.store.model.SysRole;
import com.store.user.dto.RoleDTO;
import com.store.user.service.ISysRoleMenuService;
import com.store.user.service.ISysRoleService;
import com.store.utils.Query;
import com.store.utils.R;
import com.store.utils.ResultVOUtil;
import com.store.vo.ResultVO;
import com.store.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chenyouhong
 * @date 2018/05/25
 */
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Autowired
    private ISysRoleService sysRoleService;

    @Autowired
    private ISysRoleMenuService sysRoleMenuService;

    @GetMapping("/roleType/{username}")
//    @ApiOperation(value = "通过ID获取")
    public ResultVO<List<String>> findRoletypeByUsername(@PathVariable(name = "username", required = true) String username) {
        EntityWrapper<SysRole> sysRoleWarpper = new EntityWrapper<>();
        SysRole sysRole = new SysRole();
        sysRole.setRoleName(username);
        sysRoleWarpper.setEntity(sysRole);
        List<SysRole> sysRoles = sysRoleService.selectList(sysRoleWarpper);
        return ResultVOUtil.success(sysRoles.stream().map(e -> e.getRoleType()).collect(Collectors.toList()));
    }

    /**
     * 通过ID查询角色信息
     *
     * @param id ID
     * @return 角色信息
     */
    @GetMapping("/{id}")
    public SysRole role(@PathVariable Integer id) {
        return sysRoleService.selectById(id);
    }

    /**
     * 添加角色
     *
     * @param roleDto 角色信息
     * @return success、false
     */
    @PostMapping
    public R<Boolean> role(@RequestBody RoleDTO roleDto) {
        return new R<>(sysRoleService.insertRole(roleDto));
    }

    /**
     * 修改角色
     *
     * @param roleDto 角色信息
     * @return success/false
     */
    @PutMapping
    public R<Boolean> roleUpdate(@RequestBody RoleDTO roleDto) {
        return new R<>(sysRoleService.updateRoleById(roleDto));
    }

    @DeleteMapping("/{id}")
    public R<Boolean> roleDel(@PathVariable Integer id) {
        SysRole sysRole = sysRoleService.selectById(id);
        sysRole.setDelFlag(CommonConstants.STATUS_DEL);
        return new R<>(sysRoleService.updateById(sysRole));
    }

    /**
     * 获取角色列表
     *
     * @param deptId  部门ID
     * @return 角色列表
     */
    @GetMapping("/roleList/{deptId}")
    public List<SysRole> roleList(@PathVariable Integer deptId) {
        return sysRoleService.selectListByDeptId(deptId);

    }

    /**
     * 分页查询角色信息
     *
     * @param params 分页对象
     * @return 分页对象
     */
    @RequestMapping("/rolePage")
    public Page rolePage(@RequestParam Map<String, Object> params) {
        params.put(CommonConstants.DEL_FLAG, CommonConstants.STATUS_NORMAL);
        return sysRoleService.selectwithDeptPage(new Query<>(params), new EntityWrapper<>());
    }

    /**
     * 更新角色菜单
     *
     * @param roleId  角色ID
     * @param menuIds 菜单结合roleList
     * @return success、false
     */
    @PutMapping("/roleMenuUpd")
    public R<Boolean> roleMenuUpd(Integer roleId, @RequestParam("menuIds[]") Integer[] menuIds) {
        SysRole sysRole = sysRoleService.selectById(roleId);
        return new R<>(sysRoleMenuService.insertRoleMenus(sysRole.getRoleType(), roleId, menuIds));
    }
}
