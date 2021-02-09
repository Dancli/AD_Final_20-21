package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.PacienteModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.example.demo.entity.User user = userRepository.findByUsername(username);
		UserBuilder builder = null;
		if (user != null) {
			builder = User.withUsername(username);
			builder.disabled(false);
			builder.password(user.getPassword());
			builder.authorities(new SimpleGrantedAuthority(user.getRole()));
		} else {
			throw new UsernameNotFoundException("No se ha encontrado al usuario.");
		}
		return builder.build();
	}
	
	@Override
	public com.example.demo.entity.User registrarPaciente(PacienteModel pacienteModel) {
		com.example.demo.entity.User user = new com.example.demo.entity.User();
    	user.setUsername(pacienteModel.getUsername());
    	user.setPassword(pacienteModel.getPassword());
    	user.setEnabled(true);
    	user.setRole("ROLE_PACIENTE");
    	return registrar(user);
	}
	
	@Override
	public com.example.demo.entity.User registrar(com.example.demo.entity.User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setEnabled(true);
		return userRepository.save(user);
	}
}
