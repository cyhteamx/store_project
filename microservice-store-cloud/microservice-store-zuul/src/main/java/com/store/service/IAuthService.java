package com.store.service;

import com.store.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * ClientAuthRpc
 * Description: 该接口不能走网关，否则会造成死循环
 *
 * @author Carter
 */
@FeignClient("microservice-store-auth")
public interface IAuthService {

    @RequestMapping(value = "/client/token",method = RequestMethod.POST)
    ResultVO<String> authorize(@RequestParam("si") String serviceId, @RequestParam("st") String secret);

    // 两个坑：1. @GetMapping不支持   2. @PathVariable得设置value

}
