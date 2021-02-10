package com.example.demo.service;

import com.example.demo.entity.Compra;

public interface CarritoService {
	
		// Método para mostar el carrito de la compra del usuario.
		public abstract Compra findCompraByIdPaciente(int idPaciente);
		
		// Método para transformar un modelo a una entidad.
		public abstract Compra transformModelToEntity(com.example.demo.model.CompraModel compraModel);
		
		// Método para transformar una entidad a un modelo.
		public abstract com.example.demo.model.CompraModel transformEntityToModel(Compra compraEntity);

}
