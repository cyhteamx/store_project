package com.store.repository;

import com.store.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,String>{
	Student findByName(String name);
	Student findByPassword(String password);
}
