package com.store.auth.service.impl;

import com.store.auth.entity.UserDetailsImpl;
import com.store.auth.service.IUserService;
import com.store.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Mr.Yangxiufeng on 2017/12/27.
 * Time:16:37
 * ProjectName:Mirco-Service-Skeleton
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

//    @Autowired
//    private RoleService roleService;
//    @Autowired
//    private PermissionService permissionService;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVO userVo = userService.findUserByUsername(username);
        return new UserDetailsImpl(userVo);
        //        RcUserEntity userEntity = new RcUserEntity();
////        RcUserEntity userEntity = userService.findByUsername(username);
//        if (userEntity == null) {
//            throw new UsernameNotFoundException("用户:" + username + ",不存在!");
//        }
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        boolean enabled = true; // 可用性 :true:可用 false:不可用
//        boolean accountNonExpired = true; // 过期性 :true:没过期 false:过期
//        boolean credentialsNonExpired = true; // 有效性 :true:凭证有效 false:凭证无效
//        boolean accountNonLocked = true; // 锁定性 :true:未锁定 false:已锁定
//
//        List<RcRoleEntity> roleValues = null;
//
////        List<RcRoleEntity> roleValues = roleService.getRoleValuesByUserId(userEntity.getId());
//        for (RcRoleEntity role:roleValues){
//            //角色必须是ROLE_开头，可以在数据库表 rc_role 中设置
//            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getValue());
//            grantedAuthorities.add(grantedAuthority);
//
//            log.info("grantedAuthorities: "+grantedAuthority.getAuthority());
//
//            //获取权限
//            List<RcMenuEntity> permissionList = null;
//
////            List<RcMenuEntity> permissionList = permissionService.getPermissionsByRoleId(role.getId());
//            for (RcMenuEntity menu:permissionList
//                 ) {
//                GrantedAuthority authority = new SimpleGrantedAuthority(menu.getCode());
//                grantedAuthorities.add(authority);
//            }
//        }
//
//        User user = new User(userEntity.getUsername(), userEntity.getPassword(),
//                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
//        return user;
    }
}
