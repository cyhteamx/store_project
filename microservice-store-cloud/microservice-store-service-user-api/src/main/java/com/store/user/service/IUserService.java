package com.store.user.service;


import com.store.user.service.hystrix.UserServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "microservice-store-service-user",fallback = UserServiceHystrix.class)
public interface IUserService {


}
