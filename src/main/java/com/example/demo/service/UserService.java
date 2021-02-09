package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.model.PacienteModel;

public interface UserService extends UserDetailsService {
	
	public abstract com.example.demo.entity.User registrar(com.example.demo.entity.User user);

	public abstract com.example.demo.entity.User registrarPaciente(PacienteModel pacienteModel);

}
