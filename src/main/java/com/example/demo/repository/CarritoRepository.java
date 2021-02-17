package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Compra;

@Repository("carritoRepository")
public interface CarritoRepository extends JpaRepository<Compra, Serializable> {

}
