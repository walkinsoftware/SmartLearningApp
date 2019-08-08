package com.ws.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Entity
@Table(name = "t_ws_topics")
@DynamicUpdate
@Data
public class Topic {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long topicId;
	
	@Column(unique = true)
	private String topicName ;
	
	 private String description;
	
	private String type;
	
	private int status ;
	
	public long accessLevel;

	@ManyToOne(cascade = {CascadeType.PERSIST,
			CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "moduleId")
	private Module module;
}
