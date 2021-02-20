package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="item_compra")
public class ItemCompra {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idItemCompra;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idMedicamento")
	private Medicamento medicamento;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="idCompra")
	private Compra compra;
	
	public ItemCompra() {
		
	}

	public ItemCompra(int idItemCompra, Medicamento medicamento, Compra compra) {
		super();
		this.idItemCompra = idItemCompra;
		this.medicamento = medicamento;
		this.compra = compra;
	}

	public int getIdItemCompra() {
		return idItemCompra;
	}

	public void setIdItemCompra(int idItemCompra) {
		this.idItemCompra = idItemCompra;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	@Override
	public String toString() {
		return "ItemCompra [idItemCompra=" + idItemCompra + ", medicamento=" + medicamento
				+ ", compra=" + compra + "]";
	}
	
}
