package com.gl.lab6.studentfest.Lab6.StudentFest.security;

import java.util.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gl.lab6.studentfest.Lab6.StudentFest.entity.Role;
import com.gl.lab6.studentfest.Lab6.StudentFest.entity.User;

public class MyUserDetails implements UserDetails {

	private User user;

	public MyUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<Role> roles = user.getRoles();
		List<SimpleGrantedAuthority> grantAuth = new ArrayList<>();

		for (Role role : roles) {
			grantAuth.add(new SimpleGrantedAuthority(role.getName()));
		}

		return grantAuth;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
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
