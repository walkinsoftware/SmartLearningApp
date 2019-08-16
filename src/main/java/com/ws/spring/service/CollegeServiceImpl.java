package com.ws.spring.service;

import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.spring.dto.CollegeDto;
import com.ws.spring.model.College;
import com.ws.spring.model.Group;
import com.ws.spring.model.Student;
import com.ws.spring.repository.CollegeRepository;
import com.ws.spring.repository.GroupRepository;
import com.ws.spring.repository.StudentRepository;

@Service
public class CollegeServiceImpl {

	@Autowired
	CollegeRepository collegeRepository;

	@Autowired
	GroupRepository groupRepository;

	@Autowired
	StudentRepository studentRepository;

	public College createCollege(CollegeDto collegeDto) {
		College college = new College();
		BeanUtils.copyProperties(collegeDto, college, "groups", "students", "studentsFile");
		Set<Group> groups = collegeDto.getGroups();
		Set<Student> students = collegeDto.getStudents();

		College createdCollege = collegeRepository.save(college);
		if (!CollectionUtils.isEmpty(groups)) {
			groups.forEach(g -> g.setCollege(createdCollege));
			groupRepository.saveAll(groups);
		}
		
		if (!CollectionUtils.isEmpty(students)) {
			students.forEach(s -> s.setCollege(createdCollege));
			studentRepository.saveAll(students);
		}
		return createdCollege;
	}

	public College updateCollege(College college) {
		return collegeRepository.save(college);
	}

	public College queryCollegeByCollegeId(long collegeId) {
		return collegeRepository.findCollegeByCollegeId(collegeId);
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
