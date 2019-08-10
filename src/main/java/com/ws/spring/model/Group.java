package com.ws.spring.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;

@Entity
@Table(name = "t_ws_group")
@DynamicUpdate
@Data
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long groupId;

	//@Column(unique = true)
	private String groupName;

	private String description;

	private int status;

	private long accessLevel;

	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @JoinColumn(name = "college_id")
	private College college;

	@OneToMany(mappedBy = "group", cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private List<Course> courses;
	
	@ManyToMany(mappedBy = "groups", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Student> students;

}
