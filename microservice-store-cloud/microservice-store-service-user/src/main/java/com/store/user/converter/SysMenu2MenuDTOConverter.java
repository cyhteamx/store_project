package com.store.user.converter;

import com.store.dto.MenuDTO;
import com.store.model.SysMenu;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class SysMenu2MenuDTOConverter {

    public static List<MenuDTO> convert(List<SysMenu> menus) {
        List<MenuDTO> MenuDTOs = new ArrayList<MenuDTO>();

        List<SysMenu> oneLevels = new ArrayList<SysMenu>();
        for (SysMenu menu: menus) {
            //TODO  isLeaf
//            if (!menu.isLeaf()) {
//                oneLevels.add(menu);
//            }
        }

        for (SysMenu menu: oneLevels) {
            MenuDTO menuDTO = new MenuDTO();
            menuDTO.setSubs(getAllSubMenu(menu, menus));
            BeanUtils.copyProperties(menu, menuDTO);
            MenuDTOs.add(menuDTO);
        }

        return MenuDTOs;
    }

    private static List<MenuDTO> getAllSubMenu(SysMenu menu, List<SysMenu> menus) {
        List<MenuDTO> items = new ArrayList<MenuDTO>();
        for (SysMenu temp: menus) {
            if (temp.getParentId().equals(menu.getId())) {
                MenuDTO t = new MenuDTO();
                BeanUtils.copyProperties(temp, t);
                items.add(t);
            }
        }
        return items;
    }
}
