package com.store.user.service;


import com.store.user.service.hystrix.UserServiceHystrix;
import com.store.dto.MenuDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "microservice-store-service-user",fallback = UserServiceHystrix.class)
public interface IUserService {

    @GetMapping("/menu/list")
    List<MenuDTO> getMenuList();
}
