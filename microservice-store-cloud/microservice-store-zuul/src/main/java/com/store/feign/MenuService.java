package com.store.feign;


import com.store.feign.fallback.MenuServiceFallbackImpl;
import com.store.vo.MenuVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

/**
 * @author lengleng
 * @date 2017/10/31
 */
@FeignClient(name = "microservice-store-service-user", fallback = MenuServiceFallbackImpl.class)
public interface MenuService {
    /**
     * 通过角色名查询菜单
     *
     * @param role 角色名称
     * @return 菜单列表
     */
    @GetMapping(value = "/menu/findMenuByRole/{role}")
    Set<MenuVO> findMenuByRole(@PathVariable("role") String role);
}
