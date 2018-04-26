package com.store.user.service;

import com.store.model.Student;

public interface IStudentService {

	Student findByNameMybatis(String name);
}
