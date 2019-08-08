package com.ws.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.spring.model.Course;
import com.ws.spring.repository.CourseRepository;

@Service
public class CourseServiceImpl {
	
	
	@Autowired
	CourseRepository courseRepository;

	public 	Course createCourse(Course course) {
		return courseRepository.save(course);
	}

	public Course updateCourse(Course course) {
		return courseRepository.save(course);
	}

	public Course queryCourseByCourseId(long courseId) {
		return courseRepository.findCourseByCourseId(courseId);
	}
	public Course queryCourseByCourseName(String courseName) {
		return courseRepository.findCoursetByCourseName(courseName);
	}

	public Course queryCourseByAccessLevel(long accessLevel) {
		return courseRepository.findCourseByAccessLevel(accessLevel);
	}

	public List<Course> queryAllCourses() {
		return courseRepository.findAll();
	}

}
