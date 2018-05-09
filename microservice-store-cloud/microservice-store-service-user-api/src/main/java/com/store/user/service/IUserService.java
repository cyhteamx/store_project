package com.store.user.service;


import com.store.dto.MenuDTO;
import com.store.model.User;
import com.store.user.service.hystrix.UserServiceHystrix;
import com.sun.org.glassfish.gmbal.ParameterNames;
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

}
