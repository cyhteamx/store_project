package com.store.mapper;

import com.store.model.Menu;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITbMenuMapper {

	@Select("SELECT * FROM TB_MENU")
	@Results({
		@Result(property="menuId",column="id"),
		@Result(property="name",column="name"),
		@Result(property="url",column="url"),
		@Result(property="number",column="number"),
		@Result(property="isleaf",column="isleaf"),
		@Result(property="level",column="level"),
		@Result(property="parentId",column="parent_Id"),
		@Result(property="icon",column="icon")
	})
	List<Menu> getMenuList();

}
