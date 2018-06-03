package com.store.auth.service;


import com.store.auth.service.hystrix.UserServiceHystrix;
import com.store.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value="microservice-store-service-user", fallback = UserServiceHystrix.class)
public interface IUserService {

    @RequestMapping(value = "/role/roleType/{username}", method = RequestMethod.GET)
    ResultVO<List<String>> findRoletypeByUsername(@PathVariable(name = "username", required = true) String username);

}
