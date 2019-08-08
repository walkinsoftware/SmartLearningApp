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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Entity
@Table(name = "t_ws_module")
@DynamicUpdate
@Data
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long moduleId;

	@Column(unique = true)
	private String moduleName;

	private String description;

	private int status;

	private long accessLevel;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "courseId")
	private Course course;

	@OneToMany(mappedBy = "module", cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private Set<Topic> topics;

}
