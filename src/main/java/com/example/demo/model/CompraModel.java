package com.example.demo.model;

import java.util.Date;

public class CompraModel {
	
	private int idCompra;
	private Date fecha;
	private float precio;
	private String idPaciente;
	
	public CompraModel() {
		super();
	}

	public CompraModel(int idCompra, Date fecha, float precio, String idPaciente) {
		super();
		this.idCompra = idCompra;
		this.fecha = fecha;
		this.precio = precio;
		this.idPaciente = idPaciente;
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

	public String getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}

	@Override
	public String toString() {
		return "CompraModel [idCompra=" + idCompra + ", fecha=" + fecha + ", precio=" + precio + ", idPaciente=" + idPaciente
				+ "]";
	}

}
