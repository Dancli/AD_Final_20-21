package com.example.demo.repository;

import com.example.demo.entity.Cita;
import com.example.demo.entity.Compra;
import com.example.demo.entity.Medico;
import com.example.demo.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("citaRepository")
public interface CitaRepository extends JpaRepository<Cita, Serializable> {
    @Query(value = "SELECT * FROM pacientes p WHERE p.idPaciente LIKE %:username%", nativeQuery = true)
    public List<Paciente> findPacienteByUsername(String username);

}

