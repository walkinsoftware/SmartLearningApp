package com.ws.spring.dto;

import com.opencsv.bean.CsvBindByName;

import lombok.Data;

@Data
public class StudentCsv {
	
	@CsvBindByName
	private String firstName;
	@CsvBindByName
	private String lastName;
	@CsvBindByName
	private String gender;
	@CsvBindByName
	private String mobileNumber;
	@CsvBindByName
	private String alternativeMobileNumber;
	@CsvBindByName
	private String mailId;
}
