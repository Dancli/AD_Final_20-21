package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="medicos")
public class Medico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMedico;
	
	@Column(name="nombre", length=30)
	private String nombre;
	
	@Column(name="apellidos", length=50)
	private String apellidos;
	
	@Column(name="edad")
	private int edad;
	
	@Column(name="fechaalta")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaAlta;
	
	@Column(name="especialidad", length=40)
	private String especialidad;
	
	@Column(name="username", length=30)
	private String username;
	
	@Column(name="password", length=30)
	private String password;

	@Column(name="activo", nullable=false)
	private boolean activo;
	
	public Medico() {
		super();
	}

	public Medico(int idMedico, String nombre, String apellidos, int edad, Date fechaAlta, String especialidad,
			String username, String password, boolean activo) {
		super();
		this.idMedico = idMedico;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.fechaAlta = fechaAlta;
		this.especialidad = especialidad;
		this.username = username;
		this.password = password;
		this.activo = activo;
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
	
	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Medico [idMedico=" + idMedico + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", fechaAlta=" +fechaAlta+  ", especialidad=" + especialidad + ", username=" + username
				+ ", password=" + password + ", activo=" + activo +"]";
	}

	
}
