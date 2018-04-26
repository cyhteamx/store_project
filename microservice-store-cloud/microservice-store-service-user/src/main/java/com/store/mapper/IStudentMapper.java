package com.store.mapper;

import com.store.entity.Student;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface IStudentMapper{

	@Select("SELECT * FROM student where name=#{name}")
	@Results({
		@Result(property="ID",column="ID"),
		@Result(property="name",column="name"),
		@Result(property="password",column="password"),
		@Result(property="age",column="age"),
		@Result(property="remark",column="remark")
	})
	Student findByMybatis(String name);

}
