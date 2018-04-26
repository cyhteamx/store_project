package com.store.user.service.impl;


import com.store.dao.IStudentDao;
import com.store.model.Student;
import com.store.user.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao studentDao;
	
	public Student findByNameMybatis(String name) {
		System.out.println("Service:findByNameMybatis..."+name);
		Student student=studentDao.findByNameMybatis(name);
		return student;
	}
}
