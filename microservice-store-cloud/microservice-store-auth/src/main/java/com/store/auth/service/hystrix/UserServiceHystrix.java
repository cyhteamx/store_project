package com.store.auth.service.hystrix;

import com.store.auth.service.IUserService;
import com.store.vo.ResultVO;
import com.store.vo.UserVO;
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

    @Override
    public UserVO findUserByUsername(String username) {
        return null;
    }

    @Override
    public UserVO findUserByMobile(String mobile) {
        return null;
    }

    @Override
    public UserVO findUserByOpenId(String openId) {
        return null;
    }

}
