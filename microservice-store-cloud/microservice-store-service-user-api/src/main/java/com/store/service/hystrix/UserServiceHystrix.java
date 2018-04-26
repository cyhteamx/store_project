package com.store.service.hystrix;

import com.store.dto.MenuDTO;
import com.store.service.IUserService;
import com.store.vo.ResultVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户服务 熔断处理
 *
 */

@Component
public class UserServiceHystrix implements IUserService {

    @Override
    public ResultVO<List<MenuDTO>> getMenuList() {
        return null;
    }
}
