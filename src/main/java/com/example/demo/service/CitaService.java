package com.example.demo.service;

import com.example.demo.entity.Cita;
import com.example.demo.model.CitaModel;

public interface CitaService {

    // Método para guardar una Cita.
    public abstract CitaModel saveCita(CitaModel citaModel);

    // Método para transformar un modelo a una entidad.
    public abstract Cita transformModelToEntity(CitaModel citaModel);

    // Método para transformar una entidad a un modelo.
    public abstract CitaModel transformEntityToModel(Cita citaEntity);
}
