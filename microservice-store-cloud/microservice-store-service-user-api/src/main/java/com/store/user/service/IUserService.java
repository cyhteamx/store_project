package com.store.user.service;


import com.store.user.dto.MenuDTO;
import com.store.user.service.hystrix.UserServiceHystrix;
import com.store.user.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "microservice-store-service-user",fallback = UserServiceHystrix.class)
public interface IUserService {

    @GetMapping("/menu/list")
    ResultVO<List<MenuDTO>> getMenuList();
}
