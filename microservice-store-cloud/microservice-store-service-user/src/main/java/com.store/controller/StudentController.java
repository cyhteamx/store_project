package com.store.controller;

import com.store.entity.Student;
import com.store.repository.StudentRepository;
import com.store.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository stuRepository;
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value="/stu/{name}")
	public Student stufindOne(@PathVariable("name") String name){
		System.out.println("----------------------------------");
		System.out.println("Controller:stufindOne..."+name);
		Student stu=this.stuRepository.findByName(name);
		System.out.println("----------------------------------");
		return stu;
	}
	
	@GetMapping(value="/stupass/{password}")
	public Student stufindByPassword(@PathVariable("password") String password){
		System.out.println("----------------------------------");
		System.out.println("Controller:stufindByPassword..."+password);
		Student stu=this.stuRepository.findByPassword(password);
		System.out.println("----------------------------------");
		return stu;
	}
	
	@GetMapping(value="/jpa/{name}")
	public Student findByNameJpa(@PathVariable("name") String name){
		System.out.println("----------------------------------");
		System.out.println("Controller:findByNameJpa..."+name);
		Student stu=studentService.findByNameJpa(name);
		System.out.println("----------------------------------");
		return stu;
	}
	
	@GetMapping(value="/jdbc/{name}")
	public Student findByNameJdbc(@PathVariable("name") String name){
		System.out.println("----------------------------------");
		System.out.println("Controller:findByNameJdbc..."+name);
		Student stu=studentService.findByNameJdbc(name);
		System.out.println("----------------------------------");
		return stu;
	}
	
	@GetMapping(value="/mybatis/{name}")
	public Student findByNameMybatis(@PathVariable("name") String name){
		System.out.println("----------------------------------");
		System.out.println("Controller:findByNameMybatis..."+name);
		Student stu=studentService.findByNameMybatis(name);
		System.out.println("----------------------------------");
		return stu;
	}
	
	@GetMapping(value="/mybatisno/{name}")
	public Student findByNameMybatisNo(@PathVariable("name") String name){
		System.out.println("----------------------------------");
		System.out.println("Controller:findByNameMybatisNo..."+name);
		Student stu=studentService.findByNameMybatisNo(name);
		System.out.println("----------------------------------");
		return stu;
	}
}
