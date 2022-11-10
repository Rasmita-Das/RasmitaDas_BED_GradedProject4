package com.gl.employee.employeemanagementga4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.employee.employeemanagementga4.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByUsername(String username);

}
