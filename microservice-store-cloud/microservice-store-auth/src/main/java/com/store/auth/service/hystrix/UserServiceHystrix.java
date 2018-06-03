package com.store.auth.service.hystrix;

import com.store.auth.service.IUserService;
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
    public ResultVO<List<String>> findRoletypeByUsername(String username) {
        return null;
    }

}
