package com.gl.employee.employeemanagementga4.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gl.employee.employeemanagementga4.entity.Employee;

public interface EmplRepository extends JpaRepository<Employee, Integer> {
	
	List<Employee> findByFirstNameContainsAndLastNameContainsAllIgnoreCase(String firstName,String lastName);

}
