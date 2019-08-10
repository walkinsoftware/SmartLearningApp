package com.ws.spring.restcontroller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.ws.spring.dto.CollegeDto;
import com.ws.spring.dto.StudentCsv;
import com.ws.spring.model.College;
import com.ws.spring.model.Student;
import com.ws.spring.service.CollegeServiceImpl;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/college")
@Api(value = "College Management System", tags = "Operations pertaining to College in College Management System")
public class CollegeController {

	@Autowired
	CollegeServiceImpl collegeService;

	@PostMapping("/v1/createCollege")
	ResponseEntity<String> createCollege(@RequestBody CollegeDto collegeDto) {
		College collegeCreated = collegeService.createCollege(collegeDto);
		return ResponseEntity.created(URI.create("/college/v1/queryCollegeById/" + collegeCreated.getCollegeId()))
				.body("");
	}

	@PostMapping("/v1/createCollegeAndStudents")
	public ResponseEntity<String> createCollegeAndStudents(@ModelAttribute CollegeDto collegeDto) {
		// Check If College contains the uploaded file with students
		MultipartFile studentsFile = collegeDto.getStudentsFile();
		if (null != studentsFile && !studentsFile.isEmpty()) {
			Reader reader;
			try {
				Set<Student> students = new HashSet<Student>();
				reader = new InputStreamReader(studentsFile.getInputStream());
				// CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
				CsvToBean<StudentCsv> csvToBean = new CsvToBeanBuilder<StudentCsv>(reader).withSkipLines(1)
						.withType(StudentCsv.class).withIgnoreLeadingWhiteSpace(true).build();
				Iterator<StudentCsv> csvUserIterator = csvToBean.iterator();

				CollectionUtils.addAll(students, csvUserIterator);
				collegeDto.setStudents(students);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		College collegeCreated = collegeService.createCollege(collegeDto);
		return ResponseEntity.created(URI.create("/college/v1/queryCollegeById/" + collegeCreated.getCollegeId()))
				.body("");
	}
	
	@PostMapping("/v1/uploadFile")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
	{
		return ResponseEntity.ok(" " + file.getSize());
	}

	@PostMapping("/v1/updateCollege")
	ResponseEntity<String> updateCollege(@RequestBody College college) {
		College collegeCreated = collegeService.updateCollege(college);
		return ResponseEntity.created(URI.create("/college/v1/queryCollegeById/" + collegeCreated.getCollegeId()))
				.body("");
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
