package com.example.demo.model;

import java.util.Date;

public class Compra {
	
	private Date fecha;
	private float precio;
	private String idPaciente;
	
	public Compra() {
		super();
	}

	public Compra(Date fecha, float precio, String idPaciente) {
		super();
		this.fecha = fecha;
		this.precio = precio;
		this.idPaciente = idPaciente;
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
		return "Compra [fecha=" + fecha + ", precio=" + precio + ", idPaciente=" + idPaciente + "]";
	}

}
