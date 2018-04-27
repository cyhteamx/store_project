package com.store.user.service;


import com.store.dto.MenuDTO;
import com.store.model.Student;
import com.store.user.service.hystrix.UserServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@FeignClient(value="microservice-store-service-user", fallback = UserServiceHystrix.class)
public interface IUserService {

    @GetMapping("/all")
    List in();

    @RequestMapping(value = "/hello/{name}",method = RequestMethod.POST)
    Student findByNameMybatis(@PathVariable("name") String name);

    @RequestMapping(value = "/menu/list", method = RequestMethod.GET)
    List<MenuDTO> getMenuList();

}
