package com.gl.employee.employeemanagementga4.service;

import org.springframework.stereotype.Service;

import com.gl.employee.employeemanagementga4.entity.Role;
import com.gl.employee.employeemanagementga4.repository.RoleRepository;

@Service
public class RoleService {

	private RoleRepository roleRepository;
	
	public Role addRole(Role role)
	{
		return roleRepository.saveAndFlush(role);
	}
}
