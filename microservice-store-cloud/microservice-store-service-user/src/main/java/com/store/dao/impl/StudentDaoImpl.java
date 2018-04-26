package com.store.dao.impl;


import com.store.dao.IStudentDao;
import com.store.mapper.IStudentMapper;
import com.store.model.Student;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;

@Repository
public class StudentDaoImpl implements IStudentDao {

	@Resource
	private IStudentMapper studentMapper;
	
	public Student findByNameMybatis(String name) {
		System.out.println("Dao:findByNameMybatis..."+name);
		Student stu=studentMapper.findByMybatis(name);
		return stu;
	}
}
