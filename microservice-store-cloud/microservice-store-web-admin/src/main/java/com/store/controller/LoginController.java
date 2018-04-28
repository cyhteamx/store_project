package com.store.controller;

import com.store.model.User;
import com.store.user.service.IUserService;
import com.store.utils.ResultVOUtil;
import com.store.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoginController {

    @Autowired
    private IUserService userService;

    @GetMapping("/login")
    public @ResponseBody
    ResultVO<User> mybatis(@RequestParam("name") String name, @RequestParam("pass") String pass){
        log.info("name:"+name);
        log.info("pass:"+pass);
        User user=new User();
        user.setName(name);
        user.setPassword(pass);
        User tempstu =userService.findByNameMybatis(user);
        return ResultVOUtil.success(userService.findByNameMybatis(user));
    }

}
