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

import com.ws.spring.model.College;
import com.ws.spring.service.CollegeServiceImpl;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/college")
@Api(value = "College Management System", tags = "Operations pertaining to College in College Management System")
public class CollegeController {
	
	@Autowired
	CollegeServiceImpl collegeService;
	
	
	@PostMapping("/v1/createCollege")
	ResponseEntity<String> createCollege(@RequestBody  College college) {
		College collegeCreated = collegeService.createCollege(college);
		return ResponseEntity.created(URI.create("/college/v1/queryCollegeById/" + collegeCreated.getCollegeId())).body("");
	}


	@PostMapping("/v1/updateCollege")
	ResponseEntity<String> updateCollege(@RequestBody College college) {
		College collegeCreated = collegeService.updateCollege(college);
		return ResponseEntity.created(URI.create("/college/v1/queryCollegeById/" + collegeCreated.getCollegeId())).body("");
	}


	@GetMapping("/v1/queryCollegeById/{id}")
	ResponseEntity<College> queryCollegeByCollegeId(@PathVariable long collegeId) {
		College college = collegeService.queryCollegeByCollegeId(collegeId);
		return ResponseEntity.ok().body(college);
	}

	
	@GetMapping("/v1/queryCollegeByMobileNumber")
	ResponseEntity<College> queryCollegeByContactNumber(@RequestParam("contactNumber") String contactNumber) {
		College college = collegeService.queryCollegeByContactNumber(contactNumber);
		return ResponseEntity.ok().body(college);
	}

	
	@GetMapping("/v1/queryCollegeByCollegeName")
	ResponseEntity<College> queryCollegeByCollegeName(@RequestParam("collegeName") String collegeName) {
		College college = collegeService.queryCollegeByCollegeName(collegeName);
		return ResponseEntity.ok().body(college);
	}

	
	@GetMapping("/v1/queryAllColleges")
	ResponseEntity<List<College>> queryAllColleges() {
		List<College> colleges = collegeService.queryAllColleges();
		return ResponseEntity.ok().body(colleges);
	}


}
