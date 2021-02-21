package com.example.demo.service;

import javax.validation.Valid;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.model.MedicoModel;
import com.example.demo.model.PacienteModel;

public interface UserService extends UserDetailsService {
	
	public abstract com.example.demo.entity.User registrar(com.example.demo.entity.User user);

	public abstract com.example.demo.entity.User registrarPaciente(@Valid PacienteModel pacienteModel);

	public abstract com.example.demo.entity.User registrarMedico(@Valid MedicoModel medicoModel);

}
