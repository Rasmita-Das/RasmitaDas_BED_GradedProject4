package com.gl.lab6.studentfest.Lab6.StudentFest.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gl.lab6.studentfest.Lab6.StudentFest.entity.Role;
import com.gl.lab6.studentfest.Lab6.StudentFest.entity.User;
import com.gl.lab6.studentfest.Lab6.StudentFest.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@Configuration
@RequiredArgsConstructor
public class PasswoedEnc {
	
private final UserRepository userRepo;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	@EventListener(ApplicationReadyEvent.class)
	public void insertUsers(ApplicationReadyEvent event) {
		
		List<Role> roles1 = new ArrayList<>();
		roles1.add(Role.builder().name("USER").build());

		List<Role> roles2 = new ArrayList<>();
		roles2.add(Role.builder().name("USER").build());
		roles2.add(Role.builder().name("ADMIN").build());
		
		User user1 = User.builder().username("USER").password(passwordEncoder().encode("USER"))
				.roles(roles1).build();
		this.userRepo.save(user1);

		User user2 = User.builder().username("ADMIN").password(passwordEncoder().encode("ADMIN"))
				.roles(roles2).build();
		this.userRepo.save(user2);
	}

}
