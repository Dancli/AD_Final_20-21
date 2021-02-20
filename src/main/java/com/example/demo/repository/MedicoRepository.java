package com.example.demo.repository;

import com.example.demo.entity.Medicamento;
import com.example.demo.entity.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;


@Repository("MedicoRepository")
public interface MedicoRepository extends JpaRepository<Medico, Serializable> {



    @Query(value="SELECT * FROM medicos m WHERE m.especialidad LIKE %:especialidad%", nativeQuery = true)
    public List<Medico> findByEspecialidad(String especialidad);

}