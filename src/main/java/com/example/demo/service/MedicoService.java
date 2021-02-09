package com.example.demo.service;



import com.example.demo.entity.Medico;
import com.example.demo.model.MedicoModel;

import java.util.List;

public interface MedicoService {

    //listar todos los medicos
    public abstract List<MedicoModel> listAllMedicos();

    //encontrar medico por idMedico
    public abstract Medico findMedicoById(int idMedico);

    //añadir medico
    public abstract MedicoModel addMedico(MedicoModel medicoModel);

    //borrar medico
    public abstract int removeMedico(int idMedico);

    //actualizar
    public abstract MedicoModel updateMedico(MedicoModel medicoModel);

    //transformar entidad a modelo
    public abstract Medico transform(MedicoModel medicoModel);

    //transformar modelo a entidad
    public abstract MedicoModel transform(Medico medico);

    MedicoModel findById(Integer idMedico);


}