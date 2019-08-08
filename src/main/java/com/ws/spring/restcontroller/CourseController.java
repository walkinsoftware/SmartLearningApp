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

import com.ws.spring.model.Course;
import com.ws.spring.service.CourseServiceImpl;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/course")
@Api(value = "Course Management System", tags = "Operations pertaining to Course in Course Management System")
public class CourseController {
	
	@Autowired
	CourseServiceImpl courseService;

	@PostMapping("/v1/createCourse")
	ResponseEntity<String> createCourse(@RequestBody Course course) {
		Course courseCreated = courseService.createCourse(course);
		return ResponseEntity.created(URI.create("/course/v1/queryCourseById/" + courseCreated.getCourseId())).body("");
	}

	@PostMapping("/v1/updateCourse")
	ResponseEntity<String> updateCourse(@RequestBody Course course) {
		Course courseCreated = courseService.updateCourse(course);
		return ResponseEntity.created(URI.create("/course/v1/queryCourseById/" + courseCreated.getCourseId())).body("");
	}

	@GetMapping("/v1/queryCourseByCourseId/{id}")
	ResponseEntity<Course> queryCourseByCourseId(@PathVariable long courseId) {
		Course course = courseService.queryCourseByCourseId(courseId);
		return ResponseEntity.ok().body(course);
	}

	@GetMapping("/v1/queryCourseByAccessLevel")
	ResponseEntity<Course> queryCourseByAccessLevel(@RequestParam("accessLevel") long accessLevel) {
		Course course = courseService.queryCourseByAccessLevel(accessLevel);
		return ResponseEntity.ok().body(course);
	}

	@GetMapping("/v1/queryCourseByCourserName")
	ResponseEntity<Course> queryCourseByCourseName(@RequestParam("CourseName") String courseName) {
		Course course = courseService.queryCourseByCourseName(courseName);
		return ResponseEntity.ok().body(course);
	}

	@GetMapping("/v1/queryAllCourses")
	ResponseEntity<List<Course>> queryAllCourses() {
		List<Course> courses = courseService.queryAllCourses();
		return ResponseEntity.ok().body(courses);
	}

	
	

}
