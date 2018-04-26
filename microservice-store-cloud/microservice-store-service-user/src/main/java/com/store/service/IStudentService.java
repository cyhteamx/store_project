package com.store.service;


import com.store.entity.Student;

public interface IStudentService {
	
	Student findByNameJpa(String name);
	Student findByNameJdbc(String name);
	Student findByNameMybatis(String name);
	Student findByNameMybatisNo(String name);
}
