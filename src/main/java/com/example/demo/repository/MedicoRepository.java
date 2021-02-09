package com.example.demo.repository;

import com.example.demo.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository("MedicoRepository")
public interface MedicoRepository extends JpaRepository<Medico, Serializable> {

}