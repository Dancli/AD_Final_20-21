package com.example.demo.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="compras")
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
	
	@OneToMany(mappedBy="compra", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ItemCompra> items;
	
	public Compra() {

	}

	public Compra(int idCompra, Date fecha, float precio, Paciente paciente, Set<ItemCompra> items) {
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
		return "Compra [idCompra=" + idCompra + ", fecha=" + fecha + ", precio=" + precio + ", paciente=" + paciente
				+ ", items=" + items + "]";
	}
	
}
