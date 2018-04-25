package com.store.dao.impl;


import com.store.dao.IStudentDao;
import com.store.entity.Student;
import com.store.mapper.IStudentMapper;
import com.store.mapper.IStudentMapperNo;
import com.store.mapper.StudentMapperJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class StudentDaoImpl implements IStudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	
	@Resource
	private IStudentMapper studentMapper;

    @Resource
	private IStudentMapperNo studentMapperNo;
	
	public Student findByNameJdbc(String name) {
		System.out.println("Dao:findByNameJdbc..."+name);
		String sql="select * from student where name=?";
		List<Student> list=jdbcTemplateObject.query(sql, new Object[]{name},new StudentMapperJdbc());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	public Student findByNameMybatis(String name) {
		System.out.println("Dao:findByNameMybatis..."+name);
		Student stu=studentMapper.findByMybatis(name);
		return stu;
	}
	
	public Student findByNameMybatisNo(String name) {
		System.out.println("Dao:findByNameMybatisNo..."+name);
		Student stu=studentMapperNo.findByNameMybatisNo(name);
		return stu;
	}
}
