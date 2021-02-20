package com.example.demo.service.impl;

import org.dozer.DozerBeanMapper;
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
	
	@Autowired
	private DozerBeanMapper dozer;
	
	@Override
	public CompraModel saveCompra(CompraModel compraModel) {
		Compra compra = transformModelToEntity(compraModel);
		return transformEntityToModel(carritoRepository.save(compra));
	}
	
	@Override
	public Compra transformModelToEntity(CompraModel compraModel) {
		return dozer.map(compraModel, Compra.class);
	}

	@Override
	public CompraModel transformEntityToModel(Compra compraEntity) {
		return dozer.map(compraEntity, CompraModel.class);
	}
	
}
