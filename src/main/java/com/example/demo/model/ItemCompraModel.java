package com.example.demo.model;

import com.example.demo.entity.Compra;
import com.example.demo.entity.Medicamento;

public class ItemCompraModel {

	private int idCompraMedicamento;
	private Compra compra;
	private Medicamento medicamento;
	
	public ItemCompraModel() {
		
	}

	public ItemCompraModel(int idCompraMedicamento, Compra compra, Medicamento medicamento) {
		super();
		this.idCompraMedicamento = idCompraMedicamento;
		this.compra = compra;
		this.medicamento = medicamento;
	}

	public int getIdCompraMedicamento() {
		return idCompraMedicamento;
	}

	public void setIdCompraMedicamento(int idCompraMedicamento) {
		this.idCompraMedicamento = idCompraMedicamento;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	@Override
	public String toString() {
		return "ItemCompraModel [idCompraMedicamento=" + idCompraMedicamento + ", compra=" + compra
				+ ", medicamento=" + medicamento + "]";
	}
	
}
