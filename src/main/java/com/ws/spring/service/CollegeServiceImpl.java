package com.ws.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ws.spring.model.College;
import com.ws.spring.repository.CollegeRepository;

@Service
public class CollegeServiceImpl {
	
	@Autowired

	CollegeRepository collegeRepository;

	
	public College createCollege(College college) {
		return collegeRepository.save(college);
	}

	public College updateCollege(College college) {
		return collegeRepository.save(college);
	}

	public College queryCollegeByCollegeId(long  collegeId) {
		return collegeRepository.findCollegeByCollegeId( collegeId);
	}
	public College queryCollegeByContactNumber(String ContactNumber) {
		return collegeRepository.findCollegeByContactNumber(ContactNumber);
	}

	public College queryCollegeByCollegeName(String collegeName) {
		return collegeRepository.findCollegeByCollegeName(collegeName);
	}

	public List<College> queryAllColleges() {
		return collegeRepository.findAll();
	}



}
