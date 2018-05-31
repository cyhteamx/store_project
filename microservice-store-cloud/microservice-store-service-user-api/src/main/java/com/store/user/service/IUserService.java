package com.store.user.service;


import com.store.dto.MenuDTO;
import com.store.model.User;
import com.store.user.service.hystrix.UserServiceHystrix;
import com.store.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value="microservice-store-service-user", fallback = UserServiceHystrix.class)
public interface IUserService {

    @GetMapping("/user/all")
    List in();

    @RequestMapping(value = "/menu/list", method = RequestMethod.GET)
    List<MenuDTO> getMenuList();

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    User findByNameMybatis(@RequestBody User user);

    /**
     * 通过用户名查询用户、角色信息
     *
     * @param username 用户名
     * @return UserVo
     */
    @GetMapping("/user/findUserByUsername/{username}")
    UserVO findUserByUsername(@PathVariable("username") String username);

}
