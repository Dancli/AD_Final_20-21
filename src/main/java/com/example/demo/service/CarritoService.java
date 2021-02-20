package com.example.demo.service;

import com.example.demo.entity.Compra;
import com.example.demo.model.CompraModel;

public interface CarritoService {
		
	// Método para guardar una compra.
	public abstract CompraModel saveCompra(CompraModel compraModel);
	
	// Método para transformar un modelo a una entidad.
	public abstract Compra transformModelToEntity(CompraModel compraModel);
		
	// Método para transformar una entidad a un modelo.
	public abstract CompraModel transformEntityToModel(Compra compraEntity);

}
