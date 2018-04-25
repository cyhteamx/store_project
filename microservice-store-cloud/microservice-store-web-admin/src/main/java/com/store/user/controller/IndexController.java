package com.store.user.controller;


import com.store.user.dto.MenuDTO;
import com.store.user.service.IUserService;
import com.store.user.utils.ResultVOUtil;
import com.store.user.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
@Slf4j
public class IndexController {

    @Autowired
    private IUserService userService;

    //订单列表
    @GetMapping("/list")
    public ResultVO<List<MenuDTO>> list() {
        return null;
//        return ResultVOUtil.success(menuService.findList(""));
    }

}
