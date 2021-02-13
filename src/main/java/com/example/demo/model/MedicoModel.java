package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MedicoModel {
	
	private int idMedico;
	private String nombre;
	private String apellidos;
	private int edad;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaAlta;
	private String especialidad;
	private String username;
	private String password;
	private Boolean activo;
	
	public MedicoModel() {
		super();
	}

	public MedicoModel(int idMedico, String nombre, String apellidos, int edad, Date fechaAlta, String especialidad,
			String username, String password,Boolean activo) {
		super();
		this.idMedico = idMedico;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.fechaAlta = fechaAlta;
		this.especialidad = especialidad;
		this.username = username;
		this.password = password;
		this.activo=activo;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "MedicoModel{" +
				"idMedico=" + idMedico +
				", nombre='" + nombre + '\'' +
				", apellidos='" + apellidos + '\'' +
				", edad=" + edad +
				", fechaAlta=" + fechaAlta +
				", especialidad='" + especialidad + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", activo=" + activo +
				'}';
	}
}
