package com.store.user.service.hystrix;

import com.store.dto.MenuDTO;
import com.store.model.User;
import com.store.user.service.IUserService;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * 用户服务 熔断处理
 *
 */

@Component
public class UserServiceHystrix implements IUserService {

    @Override
    public List in() {
        return null;
    }

    @Override
    public User findByNameMybatis(User user) {
        System.out.println(user.getName()+":_:"+user.getPassword());
        return null;
    }

    @Override
    public List<MenuDTO> getMenuList() {
        return null;
    }
}
