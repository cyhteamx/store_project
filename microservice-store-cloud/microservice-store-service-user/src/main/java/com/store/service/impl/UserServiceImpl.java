package com.store.service.impl;



import com.store.user.dto.MenuDTO;
import com.store.user.mapper.ITbMenuMapper;
import com.store.user.service.IUserService;
import com.store.user.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserServiceImpl implements IUserService {

	@Autowired
	private ITbMenuMapper tbMenuMapper;

	@Override
	public ResultVO<List<MenuDTO>> getMenuList() {
		tbMenuMapper.getMenuList();
		return null;
	}
}
