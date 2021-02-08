package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pacientes")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPaciente;
	
	@Column(name="nombre", length=30)
	private String nombre;
	
	@Column(name="apellidos", length=50)
	private String apellidos;
	
	@Column(name="edad")
	private int edad;
	
	@Column(name="direccion", length=100)
	private String direccion;
	
	@Column(name="foto", length=100)
	private String foto;
	
	@Column(name="username", length=30)
	private String username;
	
	@Column(name="password", length=30)
	private String password;
	
	public Paciente() {
		super();
	}

	public Paciente(int idPaciente, String nombre, String apellidos, int edad, String direccion, String foto,
			String username, String password) {
		super();
		this.idPaciente = idPaciente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.direccion = direccion;
		this.foto = foto;
		this.username = username;
		this.password = password;
	}

    public Paciente(Integer idPaciente, String nombre) {
    }

    public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
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

	@Override
	public String toString() {
		return "Paciente [idPaciente=" + idPaciente + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad="
				+ edad + ", direccion=" + direccion + ", foto=" + foto + ", username=" + username + ", password="
				+ password + "]";
	}
	
}
