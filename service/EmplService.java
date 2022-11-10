package com.gl.employee.employeemanagementga4.service;

import java.util.List;

import com.gl.employee.employeemanagementga4.entity.Employee;
import com.gl.employee.employeemanagementga4.entity.Role;
import com.gl.employee.employeemanagementga4.entity.User;

public interface EmplService {
	
	public String addEmp(Employee emp);
	
	public List<Employee> fetchAllEmp(String order);

	public Employee findEmpById(int theId);
	
	public List<Employee> findBy(String firstName);
	
	public String updateEmp(Employee emp);

	public String deleteById(int theId);
	
	public User addUser(User user);
	
	public Role addRole(Role role);

	String save(Employee emp);
}
