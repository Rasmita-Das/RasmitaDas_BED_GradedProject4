package com.gl.employee.employeemanagementga4.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gl.employee.employeemanagementga4.entity.Role;
import com.gl.employee.employeemanagementga4.entity.User;

public class MyUserDetails implements UserDetails {
	
private User user;
	
	public void UserDetailsImpl(User user){
		this.user=user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Role> roles=user.getRoles();
		List<SimpleGrantedAuthority> auth=new ArrayList<>();
		for(Role role:roles)
			auth.add(new SimpleGrantedAuthority(role.getName()));
		return auth;
	}

	@Override
	public String getPassword() {
		return this.getPassword();
	}

	@Override
	public String getUsername() {
		return this.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}