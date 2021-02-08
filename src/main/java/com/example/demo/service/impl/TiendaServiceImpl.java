package com.example.demo.service.impl;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Medicamento;
import com.example.demo.repository.TiendaRepository;
import com.example.demo.service.TiendaService;

@Service("tiendaService")
public class TiendaServiceImpl implements TiendaService {
	
	@Autowired
	@Qualifier("tiendaRepository")
	private TiendaRepository tiendaRepository;
	
	@Autowired
	private DozerBeanMapper dozer;
	
	@Override
	public Page<com.example.demo.model.Medicamento> paginateMedicamentos(int number, int size) {
		Pageable pageable = PageRequest.of(number - 1, size, Sort.by("nombre"));
		Page<Medicamento> pageMedicamentoEntity = this.tiendaRepository.findAll(pageable);
		Page<com.example.demo.model.Medicamento> pageMedicamentoModel = pageMedicamentoEntity.map(
				(medicamentoEntity -> transformEntityToModel(medicamentoEntity))
		);
		return pageMedicamentoModel;
	}
	
	@Override
	public Page<com.example.demo.model.Medicamento> findAllByKeyword(int number, int size, String keyword) {
		Pageable pageable = PageRequest.of(number - 1, size, Sort.by("nombre"));
		Page<Medicamento> pageMedicamentoEntity = this.tiendaRepository.findAllByKeyword(keyword, pageable);
		Page<com.example.demo.model.Medicamento> pageMedicamentoModel = pageMedicamentoEntity.map(
				(medicamentoEntity -> transformEntityToModel(medicamentoEntity))
		);
		return pageMedicamentoModel;
	}
	
	@Override
	public com.example.demo.model.Medicamento addMedicamento(com.example.demo.model.Medicamento medicamentoModel) {
		System.out.println("Añadir medicamento.");
		return null;
	}

	@Override
	public com.example.demo.model.Medicamento updateMedicamento(com.example.demo.model.Medicamento medicamentoModel) {
		System.out.println("Editar medicamento.");
		return null;
	}
	
	@Override
	public com.example.demo.model.Medicamento stockMedicamento(com.example.demo.model.Medicamento medicamentoModel) {
		System.out.println("Aumentar el stock de un medicamento.");
		return null;
	}

	@Override
	public int removeMedicamento(int idMedicamento) {
		System.out.println("Borrar medicamento.");
		return 0;
	}

	@Override
	public Medicamento transformModelToEntity(com.example.demo.model.Medicamento medicamentoModel) {
		return dozer.map(medicamentoModel, Medicamento.class);
	}

	@Override
	public com.example.demo.model.Medicamento transformEntityToModel(Medicamento medicamento) {
		return dozer.map(medicamento, com.example.demo.model.Medicamento.class);
	}
	
}
