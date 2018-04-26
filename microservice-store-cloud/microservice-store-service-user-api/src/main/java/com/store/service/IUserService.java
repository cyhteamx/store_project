package com.store.service;


import com.store.service.hystrix.UserServiceHystrix;
import com.store.dto.MenuDTO;
import com.store.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "microservice-store-service-user",fallback = UserServiceHystrix.class)
public interface IUserService {

    @GetMapping("/menu/list")
    List<MenuDTO> getMenuList();
}
