package com.store.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.store.model.SysMenu;
import com.store.vo.MenuVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单权限表 Mapper 接口
 *
 * @author chenyouhong
 * @since 2018-05-19
 */
public interface ISysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 查询当前用户登录的菜单
     * @param userName
     * @return
     */
    List<SysMenu> findMenuByUserName(String userName);

    /**
     * 通过角色名查询菜单
     *
     * @param role 角色名称
     * @return 菜单列表
     */
    List<MenuVO> findMenuByRoleName(@Param("role") String role);

}