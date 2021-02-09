package com.example.demo.model;

import java.util.Date;

public class CitaModel {
	
	private String idCita;
	private String idPaciente;
	private String idMedico;
	private Date fecha;
	private String observaciones;
	
	public CitaModel() {
		super();
	}

	public CitaModel(String idCita, String idPaciente, String idMedico, Date fecha, String observaciones) {
		super();
		this.idCita = idCita;
		this.idPaciente = idPaciente;
		this.idMedico = idMedico;
		this.fecha = fecha;
		this.observaciones = observaciones;
	}

	public String getIdCita() {
		return idCita;
	}

	public void setIdCita(String idCita) {
		this.idCita = idCita;
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
		return "CitaModel [idCita=" + idCita + ", idPaciente=" + idPaciente + ", idMedico=" + idMedico + ", fecha=" + fecha
				+ ", observaciones=" + observaciones + "]";
	}
	
	
	
}
