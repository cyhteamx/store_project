package com.store.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.store.interceptor.DataScope;
import com.store.model.SysUser;
import com.store.utils.Query;
import com.store.vo.UserVO;

import java.util.List;

/**
 * 用户表 Mapper 接口
 *
 * @author chenyouhong
 * @since 2018-05-19
 */
public interface ISysUserMapper extends BaseMapper<SysUser> {

    /**
     * 通过用户名查询用户信息（含有角色信息）
     *
     * @param username 用户名
     * @return userVo
     */
    UserVO selectUserVoByUsername(String username);

    /**
     * 分页查询用户信息（含角色）
     *
     * @param dataScope 数据权限
     * @param query     查询条件
     * @return list
     */
    List selectUserVoPageDataScope(Query query, DataScope dataScope);

    /**
     * 通过手机号查询用户信息（含有角色信息）
     *
     * @param mobile 用户名
     * @return userVo
     */
    UserVO selectUserVoByMobile(String mobile);

    /**
     * 通过openId查询用户信息
     *
     * @param openId openid
     * @return userVo
     */
    UserVO selectUserVoByOpenId(String openId);

    /**
     * 通过ID查询用户信息
     *
     * @param id 用户ID
     * @return userVo
     */
    UserVO selectUserVoById(Integer id);

}