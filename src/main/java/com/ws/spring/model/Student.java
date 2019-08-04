package com.ws.spring.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "t_ws_student")
@DynamicUpdate
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private long studentId;

	private String firstName;

	private String lastName;

	@Column(unique = true)
	private String userName;

	private String gender;

	@Column(unique = true)
	private String mobileNumber;

	private String alternativeMobileNumber;

	private String imeiNubmer;

	@Column(unique = true)
	private String mailId;
	
	@CreationTimestamp
	private LocalDateTime insertedDate;

	@UpdateTimestamp
	private LocalDateTime updatedDate;
	
	private long creaedBy;
	
	private long updatedBy;

}
