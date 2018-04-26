package com.store.user.service.impl;

//import com.store.converter.Menu2MenuDTOConverter;
import com.store.dto.MenuDTO;
//import com.store.mapper.ITbMenuMapper;
//import com.store.model.Menu;
import com.store.mapper.IStudentMapper;
import com.store.model.Student;
import com.store.user.service.IUserService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

//@Api(value = "API - UserServiceImpl", description = "内容操作")
@RestController
public class UserServiceImpl implements IUserService {

	//@Autowired
	//private ITbMenuMapper tbMenuMapper;

    @Resource
    private IStudentMapper studentMapper;

	//@Override
	public List<MenuDTO> getMenuList() {
		/*List<Menu> menus = tbMenuMapper.getMenuList();
		List<MenuDTO> menuDTOList = Menu2MenuDTOConverter.convert(menus);
		return menuDTOList;*/
		return null;
	}

    @Override
    public List in() {
	    List a=new ArrayList();
	    a.add("1");
	    a.add("2");
	    a.add("2");
        return a;
    }

    //@Override
    //@RequestMapping("hello/{name}")
    public Student findByNameMybatis(@PathVariable("name") String name) {
	    System.out.println("xxxxx:"+name);
        return studentMapper.findByMybatis(name);
    }
}
