package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import com.example.demo.entity.Medicamento;
import com.example.demo.model.MedicamentoModel;

public interface TiendaService {
	
	// Método para paginar todos los medicamentos.
	public abstract Page<com.example.demo.model.MedicamentoModel> paginateMedicamentos(int pagNum, int pagSize);
	
	// Método para paginar todos los medicamentos dado un filtro de búsqueda.
	public abstract Page<com.example.demo.model.MedicamentoModel> findAllByKeyword(int pagNum, int pagSize, String keyword);
	
	// Método para guardar un medicamento.
	public abstract com.example.demo.model.MedicamentoModel saveMedicamento(com.example.demo.model.MedicamentoModel medicamentoModel);
	
	// Método para borrar un medicamento.
	public abstract int removeMedicamento(int idMedicamento);
	
	// Método para transformar un modelo a una entidad.
	public abstract Medicamento transformModelToEntity(com.example.demo.model.MedicamentoModel medicamentoModel);
	
	// Método para transformar una entidad a un modelo.
	public abstract com.example.demo.model.MedicamentoModel transformEntityToModel(Medicamento medicamentoEntity);
	
	// Método para encontrar un medicamento por su identificador.
	public abstract Medicamento findMedicamentoById(int idMedicamento);
	
	// Método para listar todos los medicamentos
	public abstract List<MedicamentoModel> listAllMedicamentos();

	
}
