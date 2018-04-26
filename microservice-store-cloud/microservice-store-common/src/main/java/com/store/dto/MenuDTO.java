package com.store.dto;

import lombok.Data;

import java.util.List;

/**
 * 菜单
 * Created by 廖师兄
 * 2018-04-15 21:19
 */
@Data
public class MenuDTO {

    /** 菜单名称. */
    private String name;

    /** 菜单URL. */
    private String url;

    /** 序号. */
    private String number;

    /** 菜单icon. */
    private String icon;

    List<MenuDTO> subs;


}
