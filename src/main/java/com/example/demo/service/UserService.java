package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.model.PacienteModel;

public interface UserService extends UserDetailsService {
	
	public abstract com.example.demo.entity.User registrar(com.example.demo.entity.User user);

	public abstract com.example.demo.entity.User registrarPaciente(PacienteModel pacienteModel);
	
	// Método para transformar un modelo a una entidad.
	public abstract com.example.demo.entity.User transformModelToEntity(com.example.demo.model.User userModel);
	
	// Método para transformar una entidad a un modelo.
	public abstract com.example.demo.model.User transformEntityToModel(com.example.demo.entity.User userEntity);

}
