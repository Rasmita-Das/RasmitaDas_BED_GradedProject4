package com.gl.employee.employeemanagementga4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.employee.employeemanagementga4.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	Role findByName(String name);

}
