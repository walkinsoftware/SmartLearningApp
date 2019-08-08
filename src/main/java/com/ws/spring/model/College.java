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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long collegeId;

	@Column(unique = true)
	private String collegeName;

	@Column(unique = true)
	private String collegeCode;

	private String description;

	private String address1;

	private String address2;

	private String city;

	private String state;

	private String pincode;

	@Column(unique = true)
	private String contactNumber;

	private String contactName;

	@OneToMany(mappedBy = "college", cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private Set<Student> students;

	@OneToMany(mappedBy = "college", cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private Set<Group> groups;

}
