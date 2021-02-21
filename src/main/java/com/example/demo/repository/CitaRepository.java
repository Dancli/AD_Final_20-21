package com.example.demo.repository;

import com.example.demo.entity.Cita;
import com.example.demo.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("citaRepository")
public interface CitaRepository extends JpaRepository<Cita, Serializable> {


}
