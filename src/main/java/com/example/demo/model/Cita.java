package com.example.demo.model;

import java.util.Date;

public class Cita {
	
	private String idPaciente;
	private String idMedico;
	private Date fecha;
	private String observaciones;
	
	public Cita() {
		super();
	}

	public Cita(String idPaciente, String idMedico, Date fecha, String observaciones) {
		super();
		this.idPaciente = idPaciente;
		this.idMedico = idMedico;
		this.fecha = fecha;
		this.observaciones = observaciones;
	}

	public String getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		return "Cita [idPaciente=" + idPaciente + ", idMedico=" + idMedico + ", fecha=" + fecha + ", observaciones="
				+ observaciones + "]";
	}
	
}
