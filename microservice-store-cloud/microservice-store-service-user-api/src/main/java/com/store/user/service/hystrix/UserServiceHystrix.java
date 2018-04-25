package com.store.user.service.hystrix;

import com.store.user.dto.MenuDTO;
import com.store.user.service.IUserService;
import com.store.user.vo.ResultVO;
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
