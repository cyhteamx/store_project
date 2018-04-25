package com.store.dao;


import com.store.entity.Student;

public interface StudentDao {
	
	Student findByNameJdbc(String name);
	Student findByNameMybatis(String name);
	Student findByNameMybatisNo(String name);
}
