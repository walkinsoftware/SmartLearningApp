package com.ws.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.spring.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	Student findStudentByStudentId(long studentId);
	
	Student findStudentByMobileNumber(String mobileNumber);
	
	Student findStudentByUserName(String userName);

}
