package com.store.dao;

import com.store.model.Student;

public interface IStudentDao {
	
	Student findByNameMybatis(String name);
}
