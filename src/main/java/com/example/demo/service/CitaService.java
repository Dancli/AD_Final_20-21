package com.example.demo.service;

import com.example.demo.entity.Cita;
import com.example.demo.entity.Medico;
import com.example.demo.entity.Paciente;
import com.example.demo.model.CitaModel;
import com.example.demo.model.PacienteModel;

public interface CitaService {

    // Método para guardar una Cita.
    public abstract CitaModel saveCita(CitaModel citaModel);

   /* //encontrar paciente por username
    public abstract Medico findPacienteByUsername(String username);
*/
    // Método para transformar un modelo a una entidad.
    public abstract Cita transformModelToEntity(CitaModel citaModel);

    // Método para transformar una entidad a un modelo.
    public abstract CitaModel transformEntityToModel(Cita citaEntity);

    //transformar entidad a modelo
    public abstract Paciente transform(PacienteModel pacienteModel);

    //transformar modelo a entidad
    public abstract PacienteModel transform(Paciente paciente);
}
