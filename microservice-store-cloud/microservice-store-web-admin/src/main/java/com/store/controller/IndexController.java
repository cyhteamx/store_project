package com.store.controller;


import com.store.dto.MenuDTO;
import com.store.model.Student;
import com.store.user.service.IUserService;
import com.store.utils.ResultVOUtil;
import com.store.vo.ResultVO;
import com.store.dto.MenuDTO;
import com.store.user.service.IUserService;
import com.store.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@Slf4j
public class IndexController {

    @Autowired
    private IUserService userService;

    //订单列表
    @GetMapping("/menu/list")
    public ResultVO<List<MenuDTO>> list() {
        List<MenuDTO> list = userService.getMenuList();
        return ResultVOUtil.success(userService.getMenuList());
    }

    @GetMapping("/all")
    public List in(){
        log.info("name");
        return userService.in();
    }

    @GetMapping("/hello/{name}")
    public @ResponseBody
    Student mybatis(@PathVariable("name") String name){
        log.info("name:"+name);
        return userService.findByNameMybatis(name);
    }

}
