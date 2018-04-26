package com.store.user.service;


import com.store.model.Student;
import com.store.user.service.hystrix.UserServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value="msa-store-user",fallback = UserServiceHystrix.class)
public interface IUserService {

    @GetMapping("/all")
    List in();

    @RequestMapping(value = "/hello/{name}",method = RequestMethod.POST)
    Student findByNameMybatis(@PathVariable("name") String name);
}
