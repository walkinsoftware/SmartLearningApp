package com.ws.spring.model;

import java.util.List;
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
@Table(name = "t_ws_group")
@DynamicUpdate
@Data
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long groupId;

	@Column(unique = true)
	private String groupName;

	private String description;

	private int status;

	private long accessLevel;

	private String draft;

	private String aprove;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "collegeId")
	private College college;

	@OneToMany(mappedBy = "group", cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private List<Course> courses;
	
	@ManyToMany(mappedBy = "groups", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Student> students;

}
