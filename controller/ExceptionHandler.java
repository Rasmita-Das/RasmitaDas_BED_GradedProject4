package com.gl.employee.employeemanagementga4.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gl.employee.employeemanagementga4.service.CustomJson;


public class ExceptionHandler {
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value=UsernameNotFoundException.class)
	public CustomJson UsernameNotFoundExceptionHandler()
	{
		return new CustomJson("username not found");
	}
	
}
