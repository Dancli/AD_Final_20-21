package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Paciente;
import com.example.demo.model.PacienteModel;

public interface PacienteService {

    //listar todos los pacientes
    public abstract List<PacienteModel> listAllPacientes();

    //encontrar paciente por id
    public abstract Paciente findPacienteById(int idPaciente);
    
    // encontrar paciente por usuario
    public abstract Paciente findPacienteByUsername(String username);
    
    //guardar paciente
    public abstract PacienteModel savePaciente(PacienteModel pacienteModel);

    //borrar paciente
    public abstract int removePaciente(int idPaciente);

    //transformar entidad a modelo
    public abstract Paciente transform(PacienteModel pacienteModel);

    //transformar modelo a entidad
    public abstract PacienteModel transform(Paciente paciente);

    PacienteModel findById(Integer idPaciente);
}