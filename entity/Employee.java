package com.gl.employee.employeemanagementga4.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Table
@Data
@NoArgsConstructor
public class Employee {

	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="First_Name")
	private String firstName;
	
	@Column(name="Last_Name")
	private String lastName;
	
	@Column(name="Email")
	private String email;
  
}
