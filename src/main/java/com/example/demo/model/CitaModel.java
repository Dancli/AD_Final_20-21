package com.example.demo.model;

import com.example.demo.entity.Medico;
import com.example.demo.entity.Paciente;

import java.util.Date;

public class CitaModel {
	
	private int idCita;
	private Paciente paciente;
	private Medico medico;
	private Date fecha;
	private String observaciones;
	
	public CitaModel() {
		super();
	}

	public CitaModel(int idCita, Paciente paciente , Medico medico, Date fecha, String observaciones) {
		super();
		this.idCita = idCita;
		this.paciente = paciente;
		this.medico = medico;
		this.fecha = fecha;
		this.observaciones = observaciones;
	}

	public int getIdCita() {
		return idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
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
		return "CitaModel{" +
				"idCita=" + idCita +
				", paciente=" + paciente+
				", medico=" + medico +
				", fecha=" + fecha +
				", observaciones='" + observaciones + '\'' +
				'}';
	}
}
