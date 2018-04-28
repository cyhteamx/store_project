package com.store.mapper;

import com.store.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface ITbUserMapper {

	@Select("SELECT * FROM tb_User where name=#{name} and password=#{password}")
	@Results({
		@Result(property="ID",column="ID"),
		@Result(property="name",column="name"),
		@Result(property="password",column="password"),
		@Result(property="age",column="age"),
		@Result(property="remark",column="remark")
	})
	User findByMybatis(@Param("name") String name, @Param("password")  String password);

}
