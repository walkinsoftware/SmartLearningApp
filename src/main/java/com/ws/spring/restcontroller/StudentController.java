package com.ws.spring.restcontroller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ws.spring.model.Student;
import com.ws.spring.service.StudentServiceImpl;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/student")
@Api(value = "Student Management System", tags = "Operations pertaining to Student in Student Management System")
public class StudentController {

	@Autowired
	StudentServiceImpl studentService;

	@PostMapping("/v1/createStudent")
	ResponseEntity<String> createStudent(@RequestBody Student student) {
		Student studentCreated = studentService.createStudent(student);
		return ResponseEntity.created(URI.create("/student/v1/queryStudentById/" + studentCreated.getStudentId())).body("");
	}

	@PostMapping("/v1/updateStudent")
	ResponseEntity<String> updateStudent(@RequestBody Student student) {
		Student studentCreated = studentService.updateStudent(student);
		return ResponseEntity.created(URI.create("/student/v1/queryStudentById/" + studentCreated.getStudentId())).body("");
	}

	@GetMapping("/v1/queryStudentById/{id}")
	ResponseEntity<Student> queryStudentById(@PathVariable long id) {
		Student student = studentService.queryStudentById(id);
		return ResponseEntity.ok().body(student);
	}

	@GetMapping("/v1/queryStudentByMobileNumber")
	ResponseEntity<Student> queryStudentByMobileNumber(@RequestParam("mobileNumber") String mobileNumber) {
		Student student = studentService.queryStudentByMobileNumber(mobileNumber);
		return ResponseEntity.ok().body(student);
	}

	@GetMapping("/v1/queryStudentByUserName")
	ResponseEntity<Student> queryStudentByUserName(@RequestParam("userName") String userName) {
		Student student = studentService.queryStudentByUserName(userName);
		return ResponseEntity.ok().body(student);
	}

	@GetMapping("/v1/queryAllStudents")
	ResponseEntity<List<Student>> queryAllStudents() {
		List<Student> students = studentService.queryAllStudents();
		return ResponseEntity.ok().body(students);
	}

}
