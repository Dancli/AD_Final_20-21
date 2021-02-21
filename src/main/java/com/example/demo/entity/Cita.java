package com.example.demo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="citas")
public class Cita {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCita;
	
	@ManyToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name="idMedico")
	private Medico medico;

	@Column(name="fecha")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	@Column(name="observaciones", length=200)
	private String observaciones;
	
	public Cita() {
		super();
	}

	public Cita(int idCita, Paciente paciente, Medico medico, Date fecha, String observaciones) {
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
		return "CitaModel [idCita=" + idCita + ", paciente=" + paciente + ", medico=" + medico + ", fecha=" + fecha
				+ ", observaciones=" + observaciones + "]";
	}
	
}
