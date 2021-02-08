package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Medicamento;

@Repository("tiendaRepository")
public interface TiendaRepository extends JpaRepository<Medicamento, Serializable>{
	
	@Query(value="SELECT * FROM medicamentos m WHERE m.nombre LIKE %:keyword%", nativeQuery = true)
	public Page<Medicamento> findAllByKeyword(String keyword, Pageable pageable);
}
