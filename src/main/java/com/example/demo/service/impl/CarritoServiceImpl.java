package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Compra;
import com.example.demo.model.CompraModel;
import com.example.demo.repository.CarritoRepository;
import com.example.demo.service.CarritoService;

@Service("carritoService")
public class CarritoServiceImpl implements CarritoService {
	
	@Autowired
	@Qualifier("carritoRepository")
	private CarritoRepository carritoRepository;
	
	@Override
	public Compra findCompraByIdPaciente(int idPaciente) {
		CompraModel compraModel = new CompraModel();
		return null;
	}

	@Override
	public Compra transformModelToEntity(com.example.demo.model.CompraModel compraModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.example.demo.model.CompraModel transformEntityToModel(Compra compraEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
