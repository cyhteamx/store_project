/**
 * 
 */
package com.store.api;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @describe 用户验证接口
 */
@FeignClient("microservice-store-zuul")
public interface IOauth {
	
	/**
	 * 请求验证
	 * @param access_token 验证码
	 * @param sourcePath 请求地址
	 * @return 结果
	 */
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @ResponseBody
    Map<String,String> check(@RequestParam("access_token") String access_token, @RequestParam("sourcePath") String sourcePath);
    
}
