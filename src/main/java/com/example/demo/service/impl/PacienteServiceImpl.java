package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Paciente;
import com.example.demo.model.PacienteModel;
import com.example.demo.repository.PacienteRepository;
import com.example.demo.service.PacienteService;

@Service("pacienteServiceImpl")
public class PacienteServiceImpl  implements PacienteService {

    @Autowired
    @Qualifier("PacienteRepository")
    private PacienteRepository pacienteRepository;

    @Autowired
    private DozerBeanMapper dozer;

    @Override
    public List<PacienteModel> listAllPacientes() {
        List<Paciente> listaPacientes = pacienteRepository.findAll();
        List<PacienteModel> listaPacientesModel = new ArrayList<>();
        listaPacientes.forEach(a -> {
            PacienteModel pacienteModel = transform(a);
            listaPacientesModel.add(pacienteModel);
        });

        Collections.sort(listaPacientesModel, (PacienteModel c1, PacienteModel c2) -> c1.getApellidos().compareTo(c2.getApellidos()));
        return listaPacientesModel;

    }

    @Override
    public Paciente findPacienteById(int idPaciente) {
        PacienteModel pacienteModel=new PacienteModel();
        Paciente paciente=transform(pacienteModel);
        paciente=pacienteRepository.findById(idPaciente).orElse(null);
        return paciente;
    }

    @Override
    public PacienteModel addPaciente(PacienteModel pacienteModel) {
        Paciente paciente = transform(pacienteModel);
        return transform(pacienteRepository.save(paciente));
    }

    @Override
    public int removePaciente(int idPaciente) {
        pacienteRepository.deleteById(idPaciente);
        return 0;
    }

    @Override
    public PacienteModel updatePaciente(PacienteModel pacienteModel) {
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

    @Override
    public PacienteModel findById(Integer idPaciente) {
        pacienteRepository.findAll();
        return null;
    }

	@Override
	public Paciente findPacienteByUsername(String username) {
		PacienteModel pacienteModel=new PacienteModel();
        Paciente paciente=transform(pacienteModel);
        paciente=pacienteRepository.findPacienteByUsername(username);
        return paciente;
	}


}