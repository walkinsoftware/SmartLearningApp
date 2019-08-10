package com.ws.spring.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Entity
@Table(name = "t_ws_college")
@DynamicUpdate
@Data
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long collegeId;

	//@Column(unique = true)
	@Column(nullable = false)
	private String collegeName;

	//@Column(unique = true)
	private String collegeCode;

	private String description;

	private String address1;

	private String address2;

	private String city;

	private String state;

	private String pincode;

	//@Column(unique = true)
	private String contactNumber;

	private String contactName;

	@OneToMany(mappedBy = "college", cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private Set<Student> students;

	@OneToMany(mappedBy = "college", cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private Set<Group> groups;

	public College() {

	}

	public College(long collegeId, String collegeName, String collegeCode, String description, String address1,
			String address2, String city, String state, String pincode, String contactNumber, String contactName,
			Set<Student> students, Set<Group> groups) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.collegeCode = collegeCode;
		this.description = description;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.contactNumber = contactNumber;
		this.contactName = contactName;
		this.students = students;
		this.students.forEach(x -> x.setCollege(this));

		this.groups = groups;
		this.groups.forEach(x -> x.setCollege(this));
	}

}
