package com.example.demo.service.impl;


import com.example.demo.entity.Cita;
import com.example.demo.entity.Medico;
import com.example.demo.entity.Paciente;
import com.example.demo.model.CitaModel;
import com.example.demo.model.MedicoModel;
import com.example.demo.model.PacienteModel;
import com.example.demo.repository.CitaRepository;
import com.example.demo.service.CitaService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("citaService")
public class CitaServiceImpl implements CitaService {

    @Autowired
    @Qualifier("citaRepository")
    private CitaRepository citaRepository;

    @Autowired
    private DozerBeanMapper dozer;

    @Override
    public CitaModel saveCita(CitaModel citaModel) {
        Cita cita=transform(citaModel);
        return transform(citaRepository.save(cita));
    }




    @Override
    public Cita transform(CitaModel citaModel) {
        return dozer.map(citaModel, Cita.class);
    }

    @Override
    public CitaModel transform(Cita cita) {
        return dozer.map(cita, CitaModel.class);
    }


}
