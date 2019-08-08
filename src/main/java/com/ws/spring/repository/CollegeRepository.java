package com.ws.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.spring.model.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {
	
College findCollegeByCollegeId(long  collegeId);
	
	College findCollegeByContactNumber(String ContactNumber);
	
	College findCollegeByCollegeName(String collegeName);


}
