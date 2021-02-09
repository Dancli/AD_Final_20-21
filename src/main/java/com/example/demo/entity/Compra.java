package com.example.demo.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="compra")
public class Compra {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCompra;
	
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column(name="precio")
	private float precio;
	
	@ManyToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@ManyToMany
	@JoinTable(
			name="compra_medicamentos", 
			joinColumns=@JoinColumn(name="idCompra", table="compra"),
			inverseJoinColumns=@JoinColumn(name="idMedicamento", table="medicamentos")
	)
	private Set<Medicamento> medicamentos;
	
	public Compra() {
		super();
	}

	public Compra(int idCompra, Date fecha, float precio, Paciente paciente, Set<Medicamento> medicamentos) {
		super();
		this.idCompra = idCompra;
		this.fecha = fecha;
		this.precio = precio;
		this.paciente = paciente;
		this.medicamentos = medicamentos;
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

	public Set<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(Set<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	@Override
	public String toString() {
		return "CompraModel [idCompra=" + idCompra + ", fecha=" + fecha + ", precio=" + precio + ", paciente=" + paciente
				+ ", medicamentos=" + medicamentos + "]";
	}
	
}
