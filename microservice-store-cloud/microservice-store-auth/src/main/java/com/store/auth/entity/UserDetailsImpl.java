package com.store.auth.entity;

import com.store.constants.CommonConstants;
import com.store.vo.UserVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author lengleng
 * @date 2017/10/29
 */
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private Integer status;
    private List<SysRole> roleList = new ArrayList<>();

    public UserDetailsImpl(UserVO userVo) {
        this.username = userVo.getUsername();
        this.password = userVo.getPassword();
        this.status = userVo.getDelFlag();
//        roleList = userVo.getRoleList();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (SysRole role : roleList) {
//            authorityList.add(new SimpleGrantedAuthority(role.getRoleCode()));
        }
//        authorityList.add(new SimpleGrantedAuthority(CommonConstants.BASE_ROLE));
        return authorityList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return CommonConstants.STATUS_LOCK == status ? false : true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return CommonConstants.STATUS_NORMAL == status ? true : false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
