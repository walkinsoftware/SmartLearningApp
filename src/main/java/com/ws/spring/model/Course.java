package com.ws.spring.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Entity
@Table(name = "t_ws_course")
@DynamicUpdate
@Data
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long courseId;

	@Column(unique = true)
	private String courseName;

	private String description;

	private int status;

	private long accessLevel;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "groupId")
	private Group group;

	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<Module> modules;

	@ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Student> students;

}
