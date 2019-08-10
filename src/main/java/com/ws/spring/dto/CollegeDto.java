package com.ws.spring.dto;

import java.io.Serializable;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ws.spring.model.Group;
import com.ws.spring.model.Student;

import lombok.Data;

@Data
public class CollegeDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2660840111692848581L;

	private String collegeName;

	private String collegeCode;

	private String description;

	private String address1;

	private String address2;

	private String city;

	private String state;

	private String pincode;

	private String contactNumber;

	private String contactName;
	
	private Set<Group> groups;
	
	private Set<Student> students;

	private MultipartFile studentsFile;
	private CommonsMultipartFile stuFile;

}
