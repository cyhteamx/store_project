package com.store.user.controller;

//@Api(value = "API - UserServiceImpl", description = "内容操作")
//@RestController
//public class UserServiceImpl implements IUserService {
//
//    @Autowired
//    private ITbUserMapper studentMapper;
//
//	@Autowired
//	private ITbMenuMapper tbMenuMapper;
//
//	@Override
//	public List<MenuDTO> getMenuList() {
//		List<Menu> menus = tbMenuMapper.getMenuList();
//		List<MenuDTO> menuDTOList = Menu2MenuDTOConverter.convert(menus);
//		return menuDTOList;
//	}
//
//    @Override
//    public List in() {
//	    List a=new ArrayList();
//	    a.add("1");
//	    a.add("2");
//	    a.add("2");
//        return a;
//    }
//
//    @Override
//    public User findByNameMybatis(@RequestBody User user) {
//		String name=user.getName();
//		String password=user.getPassword();
//	    System.out.println(name+":::"+password);
//		User u = studentMapper.findByMybatis(name,password);
//        return studentMapper.findByMybatis(name,password);
//    }
//
//	@Override
//	public UserVO findUserByUsername(String username) {
//		return null;
//	}
//
//}
