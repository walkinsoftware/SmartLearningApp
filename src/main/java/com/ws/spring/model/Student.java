package com.ws.spring.model;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Entity
@Table(name = "t_ws_student")
@DynamicUpdate
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentId;

	private String firstName;

	private String lastName;

	//@Column(unique = true)
	private String userName;

	private String gender;

	//@Column(unique = true)
	private String mobileNumber;

	private String alternativeMobileNumber;

	private String imeiNubmer;

	//@Column(unique = true)
	private String mailId;
	
	@CreationTimestamp
	private LocalDateTime insertedDate;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedDate;
	
	private long createdBy;
	
	private long updatedBy;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @JoinColumn(name = "college_id")
	private College college;
	
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "student_group", joinColumns = @JoinColumn(name = "studentId", referencedColumnName = "studentId"), inverseJoinColumns = @JoinColumn(name = "groupId", referencedColumnName = "groupId"))
    private Set<Group> groups;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "studentId", referencedColumnName = "studentId"), inverseJoinColumns = @JoinColumn(name = "courseId", referencedColumnName = "courseId"))
    private Set<Course> courses;

}
