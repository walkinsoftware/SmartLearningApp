package com.ws.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.spring.model.Student;
import com.ws.spring.repository.StudentRepository;

@Service
public class StudentServiceImpl {

	@Autowired
	StudentRepository studentRepository;

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student queryStudentById(long id) {
		return studentRepository.findStudentById(id);
	}
	public Student queryStudentByMobileNumber(String mobileNumber) {
		return studentRepository.findStudentByMobileNumber(mobileNumber);
	}

	public Student queryStudentByUserName(String userName) {
		return studentRepository.findStudentByUserName(userName);
	}

	public List<Student> queryAllStudents() {
		return studentRepository.findAll();
	}

}
