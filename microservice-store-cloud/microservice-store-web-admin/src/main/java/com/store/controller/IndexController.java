package com.store.controller;


import com.store.dto.MenuDTO;
import com.store.user.service.IUserService;
import com.store.utils.ResultVOUtil;
import com.store.vo.ResultVO;
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
        return ResultVOUtil.success(userService.getMenuList());
    }

}
