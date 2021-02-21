package com.example.demo.service.impl;


import com.example.demo.entity.Cita;
import com.example.demo.model.CitaModel;
import com.example.demo.service.CitaService;
import org.springframework.stereotype.Service;

@Service("citaService")
public class CitaServiceImpl implements CitaService {
    @Override
    public CitaModel saveCita(CitaModel citaModel) {
        return null;
    }

    @Override
    public Cita transformModelToEntity(CitaModel citaModel) {
        return null;
    }

    @Override
    public CitaModel transformEntityToModel(Cita citaEntity) {
        return null;
    }
}
