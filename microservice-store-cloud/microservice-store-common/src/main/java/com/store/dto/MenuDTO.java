package com.store.dto;

import lombok.Data;

import java.util.List;

/**
 * 菜单
 * @author chenyouhong
 * @since 2018-05-20
 */
@Data
public class MenuDTO {

    /** 菜单名称. */
    private String name;

    /** 菜单URL. */
    private String url;

    /** 序号. */
    private String sort;

    /** 菜单icon. */
    private String icon;

    List<MenuDTO> subs;


}
