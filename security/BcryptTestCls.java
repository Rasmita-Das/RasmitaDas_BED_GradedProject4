package com.gl.employee.employeemanagementga4.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class BcryptTestCls {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		String pass=passwordEncoder.encode("admin");
		System.out.println(pass);
	}

}
