package com.ws.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.spring.model.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, String >  {
	
Course findCourseByCourseId(long courseId);
	
Course findCoursetByCourseName(String courseName);

	
Course findCourseByAccessLevel(long accessLevel);

	
	

}
