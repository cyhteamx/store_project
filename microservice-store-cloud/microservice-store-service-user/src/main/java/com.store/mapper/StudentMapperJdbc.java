package com.store.mapper;

import com.store.entity.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapperJdbc implements RowMapper<Student>{

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Student stu=new Student();
		stu.setID(rs.getString("ID"));
		stu.setName(rs.getString("name"));
		stu.setPassword(rs.getString("password"));
		stu.setAge(rs.getInt("age"));
		stu.setRemark(rs.getString("remark"));
		
		return stu;
	}

}
