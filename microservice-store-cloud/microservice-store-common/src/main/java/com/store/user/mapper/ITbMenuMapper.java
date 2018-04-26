package com.store.user.mapper;

import com.store.user.model.Menu;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITbMenuMapper {

	@Select("SELECT * FROM tb_menu")
	@Results({
		@Result(property="ID",column="ID"),
		@Result(property="name",column="name"),
		@Result(property="password",column="password"),
		@Result(property="age",column="age"),
		@Result(property="remark",column="remark")
	})
	List<Menu> getMenuList();

}
