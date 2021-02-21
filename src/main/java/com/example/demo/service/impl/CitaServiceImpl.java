package com.example.demo.service.impl;


import com.example.demo.entity.Cita;
import com.example.demo.entity.Paciente;
import com.example.demo.model.CitaModel;
import com.example.demo.model.PacienteModel;
import com.example.demo.repository.CitaRepository;
import com.example.demo.service.CitaService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("citaService")
public class CitaServiceImpl implements CitaService {

    @Autowired
    @Qualifier("citaRepository")
    private CitaRepository citaRepository;

    @Autowired
    private DozerBeanMapper dozer;

    @Override
    public CitaModel saveCita(CitaModel citaModel) {
        return null;
    }

    /*@Override
    public Paciente findPacienteByUsername(String username) {
        PacienteModel pacienteModel=new PacienteModel();
        Cita paciente=transform(pacienteModel);
        paciente=citaRepository.findById(username).orElse(null);
        return paciente;    }

    @Override
    public Paciente findPacienteById(int idPaciente) {
        PacienteModel pacienteModel=new PacienteModel();
        Paciente paciente=transform(pacienteModel);
        paciente=pacienteRepository.findById(idPaciente).orElse(null);
        return paciente;
    }*/

    @Override
    public Cita transformModelToEntity(CitaModel citaModel) {
        return null;
    }

    @Override
    public CitaModel transformEntityToModel(Cita citaEntity) {
        return null;
    }

    @Override
    public Paciente transform(PacienteModel pacienteModel) {
        return dozer.map(pacienteModel, Paciente.class);
    }

    @Override
    public PacienteModel transform(Paciente paciente) {
        return dozer.map(paciente, PacienteModel.class);
    }
}
