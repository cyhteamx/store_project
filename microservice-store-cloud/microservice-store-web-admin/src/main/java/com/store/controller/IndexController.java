package com.store.controller;


import com.store.dto.MenuDTO;
import com.store.model.Student;
import com.store.user.service.IUserService;
import com.store.utils.ResultVOUtil;
import com.store.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/menu")
@Slf4j
public class IndexController {

    @Autowired
    private IUserService userService;

    //订单列表
    /*@GetMapping("/list")
    public ResultVO<List<MenuDTO>> list() {
        return ResultVOUtil.success(userService.getMenuList());
    }*/

    @GetMapping("/all")
    public List in(){
        log.info("name");
        return userService.in();
    }

    @GetMapping("/hello/{name}")
    public @ResponseBody Student mybatis(@PathVariable("name") String name){
        log.info("name:"+name);
        return userService.findByNameMybatis(name);
    }

}
