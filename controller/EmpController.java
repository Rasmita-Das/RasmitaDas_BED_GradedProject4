package com.gl.employee.employeemanagementga4.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.gl.employee.employeemanagementga4.entity.Employee;
import com.gl.employee.employeemanagementga4.entity.Role;
import com.gl.employee.employeemanagementga4.entity.User;
import com.gl.employee.employeemanagementga4.service.EmplService;

@RestController
@RequestMapping("/employee")
public class EmpController {
	
	@Autowired
	private EmplService empsrvc;

	//1. adding roles method
	@PostMapping("/role")
	public Role saveRole(@RequestBody Role role) {
		return empsrvc.addRole(role);
	}
	
	//2. adding Users in the db
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return empsrvc.addUser(user);
	}

	//Endpoint to list all the employees in order stored in the database.
	@GetMapping("/employees/{order}")
	public List<Employee> listAllEmployees(@PathVariable("order") String order) {
		return empsrvc.fetchAllEmp(order);
	}

	
	 //5.Endpoints to fetch the employee by id stored in the database.
	@GetMapping("/employees/{employeeId}")
	public Employee fetchEmployee(@PathVariable int empId) {
		Employee emp = empsrvc.findEmpById(empId);
		if (emp == null) {
			throw new RuntimeException("Employee not found - " + empId);
		}
		return emp;
	}

	/**
	 * Endpoint to add the employee to be stored in the database.
	 * 
	 * @param employee
	 * @return
	 */
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee emp) {
		emp.setId(0);
		empsrvc.addEmp(emp);
		return emp;
	}

	// 6.Endpoint to update the employee to be stored in the database.
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee emp) {
		empsrvc.addEmp(emp);
		return emp;
	}

	// 7.Endpoint to delete the employee by id stored in the database.
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int empId) {
		Employee emp = empsrvc.findEmpById(empId);
		if (emp == null) {
			throw new RuntimeException("Employee:" + empId + " not found");
		}
		empsrvc.deleteById(empId);
		return "Employee:" + empId + " Deleted successfully";
	}

	//8.Endpoint to fetch the employee by first name.
	@GetMapping("/employees/search/{firstName}")
	public List<Employee> fetchEmployeesByFirstName(@PathVariable String firstName) {
		return empsrvc.fetchAllEmp(firstName);
	}
	
	//9 Endpoint to list all the employees stored in the database.
	@GetMapping("/employees")
	public List<Employee> listAllEmployees() {
		return empsrvc.fetchAllEmp(null);
	}
	

}
