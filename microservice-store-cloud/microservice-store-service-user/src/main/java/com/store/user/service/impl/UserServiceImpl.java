package com.store.user.service.impl;


import com.store.converter.Menu2MenuDTOConverter;
import com.store.dto.MenuDTO;
import com.store.mapper.ITbMenuMapper;
import com.store.mapper.ITbUserMapper;
import com.store.model.Menu;
import com.store.model.User;
import com.store.user.service.IUserService;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@Api(value = "API - UserServiceImpl", description = "内容操作")
@RestController
public class UserServiceImpl implements IUserService {

    @Autowired
    private ITbUserMapper studentMapper;

	@Autowired
	private ITbMenuMapper tbMenuMapper;

	@Override
	public List<MenuDTO> getMenuList() {
		List<Menu> menus = tbMenuMapper.getMenuList();
		List<MenuDTO> menuDTOList = Menu2MenuDTOConverter.convert(menus);
		return menuDTOList;
	}

    @Override
    public List in() {
	    List a=new ArrayList();
	    a.add("1");
	    a.add("2");
	    a.add("2");
        return a;
    }

    @Override
    public User findByNameMybatis(@RequestBody User user) {
		String name=user.getName();
		String password=user.getPassword();
	    System.out.println(name+":::"+password);
		User u = studentMapper.findByMybatis(name,password);
        return studentMapper.findByMybatis(name,password);
    }

}
