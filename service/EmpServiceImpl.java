package com.gl.employee.employeemanagementga4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gl.employee.employeemanagementga4.entity.Employee;
import com.gl.employee.employeemanagementga4.entity.Role;
import com.gl.employee.employeemanagementga4.entity.User;
import com.gl.employee.employeemanagementga4.repository.EmplRepository;
import com.gl.employee.employeemanagementga4.repository.RoleRepository;
import com.gl.employee.employeemanagementga4.repository.UserRepository;

@Service
public class EmpServiceImpl implements EmplService{

	@Autowired
	EmplRepository emplrepo;
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	RoleRepository rolerepo;

	@Override
	public String addEmp(Employee emp) {
		emplrepo.saveAndFlush(emp);
		return "Employee Added Successfully.";
	}

	@Override
	public List<Employee> fetchAllEmp(String order) {
		if ("ASC".equals(order)) {
			return emplrepo.findAll(Sort.by(Direction.ASC, "id"));
		}else if("DESC".equals(order)){
			return emplrepo.findAll(Sort.by(Direction.DESC, "id"));
		}
		return emplrepo.findAll();
	}

	@Override
	public Employee findEmpById(int theId) {
		Optional<Employee> output = emplrepo.findById(theId);
		Employee emp = null;
		if(output.isPresent()) {
			emp = output.get();
		}else {
			throw new RuntimeException("Unable to find employee" + theId);
		}
		return emp;
	}

	@Override
	public List<Employee> findBy(String firstName) {
		Employee emp = new Employee();
		emp.setFirstName(firstName);
		ExampleMatcher exmatcher = ExampleMatcher.matching().withMatcher(firstName, ExampleMatcher.GenericPropertyMatchers.exact())
									.withIgnorePaths("id", "lastName", "email");
		Example<Employee> example = Example.of(emp, exmatcher);
		return emplrepo.findAll(example);
	}

	@Override
	public String updateEmp(Employee emp) {
		emplrepo.saveAndFlush(emp);
		return "Employee Updated Successfully.";
	}

	@Override
	public String save(Employee emp) {
		emplrepo.save(emp);
		return "EMployee Saved Successfully.";
	}

	@Override
	public String deleteById(int theId) {
		emplrepo.deleteById(theId);
		return "Employee Details Deleted Successfully.";
	}

	@Override
	public User addUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		List<Role> role =user.getRoles();
		user.setRoles(new ArrayList<Role>());
		
		for(Role role1 : role) {
			role1 = rolerepo.findByName(role1.getName());
		}if (role == null) {
			return null;
		}else {
			user.getRoles().addAll(role);
		}

		return userrepo.save(user);
	}

	@Override
	public Role addRole(Role role) {
		return rolerepo.save(role);
	}

}
