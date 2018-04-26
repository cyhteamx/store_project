package com.store.dao;


import com.store.entity.Student;

public interface IStudentDao {
	
	Student findByNameJdbc(String name);
	Student findByNameMybatis(String name);
	Student findByNameMybatisNo(String name);
}
