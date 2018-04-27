package com.store.user.service.impl;

import com.store.converter.Menu2MenuDTOConverter;
import com.store.dto.MenuDTO;
import com.store.mapper.ITbMenuMapper;
import com.store.model.Menu;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceImplTest {

    @Autowired
    private ITbMenuMapper tbMenuMapper;

    @Test
    public void getMenuList() {
        List<Menu> menus = tbMenuMapper.getMenuList();
        List<MenuDTO> menuDTOList = Menu2MenuDTOConverter.convert(menus);
    }
}