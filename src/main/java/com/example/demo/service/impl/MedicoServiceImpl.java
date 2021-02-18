package com.example.demo.service.impl;

import com.example.demo.entity.Medico;
import com.example.demo.entity.Paciente;
import com.example.demo.model.MedicoModel;
import com.example.demo.model.PacienteModel;
import com.example.demo.repository.MedicoRepository;
import com.example.demo.service.MedicoService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service("MedicoServiceImpl")
public class MedicoServiceImpl implements MedicoService {


    @Autowired
    @Qualifier("MedicoRepository")
    private MedicoRepository medicoRepository;

    @Autowired
    private DozerBeanMapper dozer;



    @Override
    public List<MedicoModel> listAllMedicos() {

        List<Medico> listaMedicos = medicoRepository.findAll();
        List<MedicoModel> listaMedicosModel = new ArrayList<>();
        listaMedicos.forEach(a -> {
            MedicoModel medicoModel = transform(a);
            listaMedicosModel.add(medicoModel);
        });

        Collections.sort(listaMedicosModel, (MedicoModel c1, MedicoModel c2) -> c1.getApellidos().compareTo(c2.getApellidos()));
        return listaMedicosModel;

    }

    @Override
    public Medico findMedicoById(int idMedico) {
        MedicoModel medicoModel=new MedicoModel();
        Medico medico=transform(medicoModel);
        medico=medicoRepository.findById(idMedico).orElse(null);
        return medico;
    }

    @Override
    public List<MedicoModel> findMedicoByEspecialidad(String especialidad) {
      System.out.println("la especialidad es "+ especialidad);

        List<Medico> listaMedicosEspecialidad = medicoRepository.findByEspecialidad(especialidad);
        List<MedicoModel> listaMedicosModel = new ArrayList<>();
        listaMedicosEspecialidad.forEach(a -> {
            MedicoModel medicoModel = transform(a);
            listaMedicosModel.add(medicoModel);
        });
        return listaMedicosModel;
    }

    @Override
    public MedicoModel addMedico(MedicoModel medicoModel) {

        Medico medico=transform(medicoModel);
        return transform(medicoRepository.save(medico));
    }

    @Override
    public int removeMedico(int idMedico) {

        medicoRepository.deleteById(idMedico);
        return 0;
    }

    @Override
    public MedicoModel updateMedico(MedicoModel medicoModel) {
        return null;
    }

    @Override
    public Medico transform(MedicoModel medicoModel) {
        return dozer.map(medicoModel, Medico.class);
    }

    @Override
    public MedicoModel transform(Medico medico) {
        return dozer.map(medico, MedicoModel.class);
    }

    @Override
    public MedicoModel findById(Integer idMedico) {
        medicoRepository.findAll();
        return null;
    }
}