package com.example.demo.repository;

import com.example.demo.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("PacienteRepository")
public interface PacienteRepository extends JpaRepository<Paciente, Serializable> {

	public abstract Paciente findPacienteByUsername(String username);
}
