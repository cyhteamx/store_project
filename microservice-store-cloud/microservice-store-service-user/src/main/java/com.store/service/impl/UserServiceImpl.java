package com.store.service.impl;



import com.store.user.dto.MenuDTO;
import com.store.user.service.IUserService;
import com.store.user.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserServiceImpl implements IUserService {

	@Override
	public ResultVO<List<MenuDTO>> getMenuList() {
		return null;
	}
}
