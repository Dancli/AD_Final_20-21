package com.example.demo.service;

import com.example.demo.entity.Cita;
import com.example.demo.entity.Medico;
import com.example.demo.entity.Paciente;
import com.example.demo.model.CitaModel;
import com.example.demo.model.MedicoModel;
import com.example.demo.model.PacienteModel;

public interface CitaService {

    // Método para guardar una Cita.
    public abstract CitaModel saveCita(CitaModel citaModel);


    /* //encontrar paciente por username
    public abstract Medico findPacienteByUsername(String username);
*/
    // Método para transformar un modelo a una entidad.
    public abstract Cita transform(CitaModel citaModel);

    // Método para transformar una entidad a un modelo.
    public abstract CitaModel transform(Cita cita);


}
