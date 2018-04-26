package com.store.service.impl;



import com.store.converter.Menu2MenuDTOConverter;
import com.store.dto.MenuDTO;
import com.store.mapper.ITbMenuMapper;
import com.store.model.Menu;
import com.store.service.IUserService;
import com.store.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserServiceImpl implements IUserService {

	@Autowired
	private ITbMenuMapper tbMenuMapper;

	@Override
	public List<MenuDTO> getMenuList() {
		List<Menu> menus = tbMenuMapper.getMenuList();
		List<MenuDTO> menuDTOList = Menu2MenuDTOConverter.convert(menus);
		return menuDTOList;
	}
}
