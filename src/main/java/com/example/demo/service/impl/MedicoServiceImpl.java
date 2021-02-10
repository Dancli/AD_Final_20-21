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
        return null;
    }

    @Override
    public MedicoModel addMedico(MedicoModel medicoModel) {

        System.out.println("los parametros del medico en el servicio "+ medicoModel.toString());
        Medico medico=transform(medicoModel);
        System.out.println("los parametros del medico en el servicio la entity "+ medico.toString());

        return transform(medicoRepository.save(medico));
    }

    @Override
    public int removeMedico(int idMedico) {
        return 0;
    }

    @Override
    public MedicoModel updateMedico(MedicoModel medicoModel) {
        return null;
    }

    @Override
    public Medico transform(MedicoModel medicoModel) {
        return null;
    }

    @Override
    public MedicoModel transform(Medico medico) {
        return null;
    }

    @Override
    public MedicoModel findById(Integer idMedico) {
        return null;
    }
}