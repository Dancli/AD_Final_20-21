package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Component
public class DefaultUsersRunner implements CommandLineRunner {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		createAdmin();
	}
	
	private void createAdmin() {
		if(userRepository.findByUsername("admin") == null) {
			User admin = new User();
			admin.setUsername("admin");
			admin.setPassword("admin");
			admin.setEnabled(true);
			admin.setRole("ROLE_ADMIN");
			userService.registrar(admin);
		}
		
	}
}
