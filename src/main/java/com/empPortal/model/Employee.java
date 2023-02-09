package com.empPortal.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.empPortal.model.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name="emp_id")
	private Long empId;
	
//	@Column(name="emp_name")
//	@NotEmpty(message="Name cannot be null")
	private String empName;
	
	//@Column(name="gender")
	
	private String gender;
	
	@JsonManagedReference
	@OneToOne(mappedBy = "emp", cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
	private User user;
}
