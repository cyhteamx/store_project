package com.store.controller;

import com.store.model.Student;
import com.store.user.service.IStudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StudentController {

	@Resource
	private IStudentService studentService;
	
	@GetMapping(value="/mybatis/{name}")
	public Student findByNameMybatis(@PathVariable("name") String name){
		System.out.println("----------------------------------");
		System.out.println("Controller:findByNameMybatis..."+name);
		Student stu=studentService.findByNameMybatis(name);
		System.out.println("----------------------------------");
		return stu;
	}
}
