package com.gl.employee.employeemanagementga4.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gl.employee.employeemanagementga4.entity.User;
import com.gl.employee.employeemanagementga4.repository.UserRepository;

@Service
public class UserService {

private UserRepository userRepository;
	
	public User addUser(@RequestBody User user)
	{
		return userRepository.saveAndFlush(user);
	}
	
}
