package com.store.user.service.impl;


import com.store.dao.IStudentDao;
import com.store.entity.Student;
import com.store.repository.IStudentRepository;
import com.store.user.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private IStudentDao studentDao;
	
	@Autowired
	private IStudentRepository stuRepository;
	
	public Student findByNameJpa(String name) {
		System.out.println("Service:findByNameJpa..."+name);
		Student student=stuRepository.findByName(name);
		return student;
	}
	
	public Student findByNameJdbc(String name) {
		System.out.println("Service:findByNameJdbc..."+name);
		Student student=studentDao.findByNameJdbc(name);
		return student;
	}
	
	public Student findByNameMybatis(String name) {
		System.out.println("Service:findByNameMybatis..."+name);
		Student student=studentDao.findByNameMybatis(name);
		return student;
	}
	
	public Student findByNameMybatisNo(String name) {
		System.out.println("Service:findByNameMybatisNo..."+name);
		Student student=studentDao.findByNameMybatisNo(name);
		return student;
	}
}
