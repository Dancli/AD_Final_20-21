package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicamentos")
public class Medicamento {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMedicamento;
	
	@Column(name="nombre", length=50)
	private String nombre;
	
	@Column(name="descripcion", length=100)
	private String descripcion;
	
	@Column(name="receta", length=1)
	private String receta;
	
	@Column(name="precio")
	private float precio;
	
	@Column(name="stock")
	private int stock;
	
	public Medicamento() {
		super();
	}

	public Medicamento(int idMedicamento, String nombre, String descripcion, String receta, float precio, int stock) {
		super();
		this.idMedicamento = idMedicamento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.receta = receta;
		this.precio = precio;
		this.stock = stock;
	}

	public int getIdMedicamento() {
		return idMedicamento;
	}

	public void setIdMedicamento(int idMedicamento) {
		this.idMedicamento = idMedicamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "MedicamentoModel [idMedicamento=" + idMedicamento + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", receta=" + receta + ", precio=" + precio + ", stock=" + stock + "]";
	}
	
}
