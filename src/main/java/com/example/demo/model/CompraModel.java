package com.example.demo.model;

import java.util.Date;
import java.util.Set;

import com.example.demo.entity.ItemCompra;
import com.example.demo.entity.Paciente;

public class CompraModel {
	
	private int idCompra;
	private Date fecha;
	private float precio;
	private Paciente paciente;
	private Set<ItemCompra> items;
	
	public CompraModel() {
		
	}

	public CompraModel(int idCompra, Date fecha, float precio, Paciente paciente, Set<ItemCompra> items) {
		super();
		this.idCompra = idCompra;
		this.fecha = fecha;
		this.precio = precio;
		this.paciente = paciente;
		this.items = items;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Set<ItemCompra> getItems() {
		return items;
	}

	public void setItems(Set<ItemCompra> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "CompraModel [idCompra=" + idCompra + ", fecha=" + fecha + ", precio=" + precio + ", paciente="
				+ paciente + ", items=" + items + "]";
	}

}
