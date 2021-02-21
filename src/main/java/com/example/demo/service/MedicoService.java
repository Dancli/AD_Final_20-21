package com.example.demo.service;



import com.example.demo.entity.Medico;
import com.example.demo.model.MedicoModel;

import java.util.List;

public interface MedicoService {

    //listar todos los medicos
    public abstract List<MedicoModel> listAllMedicos();

    //encontrar medico por idMedico
    public abstract Medico findMedicoById(int idMedico);

    //encontrar medico por especialidad
    public abstract List<MedicoModel> findMedicoByEspecialidad(String especialidad);

    //guardar medico
    public abstract MedicoModel saveMedico(MedicoModel medicoModel);

    //borrar medico
    public abstract int removeMedico(int idMedico);

    //transformar entidad a modelo
    public abstract Medico transform(MedicoModel medicoModel);

    //transformar modelo a entidad
    public abstract MedicoModel transform(Medico medico);

    MedicoModel findById(Integer idMedico);


}