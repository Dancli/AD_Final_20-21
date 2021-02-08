package com.example.demo.model;

public class Medicamento {
	
	private String nombre;
	private String descripcion;
	private String receta;
	private float precio;
	private int stock;
	
	public Medicamento() {
		super();
	}

	public Medicamento(String nombre, String descripcion, String receta, float precio, int stock) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.receta = receta;
		this.precio = precio;
		this.stock = stock;
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
		return "Medicamento [nombre=" + nombre + ", descripcion=" + descripcion + ", receta=" + receta + ", precio="
				+ precio + ", stock=" + stock + "]";
	}
	
	
}
