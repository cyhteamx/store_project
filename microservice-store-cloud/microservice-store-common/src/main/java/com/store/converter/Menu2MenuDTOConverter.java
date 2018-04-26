package com.store.converter;

/*import com.store.dto.MenuDTO;
import com.store.enums.MenuNodeEnum;
import com.store.model.Menu;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;*/

public class Menu2MenuDTOConverter {

    /*public static List<MenuDTO> convert(List<Menu> menus) {
        List<MenuDTO> MenuDTOs = new ArrayList<MenuDTO>();

        List<Menu> oneLevels = new ArrayList<Menu>();
        for (Menu menu: menus) {
            if (MenuNodeEnum.PARENTNODE.getCode() == menu.getIsleaf()) {
                oneLevels.add(menu);
            }
        }

        for (Menu menu: oneLevels) {
            MenuDTO menuDTO = new MenuDTO();
            menuDTO.setSubs(getAllSubMenu(menu, menus));
            BeanUtils.copyProperties(menu, menuDTO);
            MenuDTOs.add(menuDTO);
        }

        return MenuDTOs;
    }

    private static List<MenuDTO> getAllSubMenu(Menu menu, List<Menu> menus) {
        List<MenuDTO> items = new ArrayList<MenuDTO>();
        for (Menu temp: menus) {
            if (temp.getParentId().equals(menu.getMenuId())) {
                MenuDTO t = new MenuDTO();
                BeanUtils.copyProperties(temp, t);
                items.add(t);
            }
        }
        return items;
    }*/
}
