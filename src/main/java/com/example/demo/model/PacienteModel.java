package com.example.demo.model;

import org.springframework.web.multipart.MultipartFile;

public class PacienteModel {

	private int idPaciente;
	private String nombre;
	private String apellidos;
	private int edad;
	private String direccion;
	private String foto;
	private String username;
	private String password;
	
	public PacienteModel() {
		super();
	}

	public PacienteModel(int idPaciente, String nombre, String apellidos, int edad, String direccion, String foto, String username,
						 String password) {
		super();
		this.idPaciente= idPaciente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.direccion = direccion;
		this.foto = foto;
		this.username = username;
		this.password = password;
	}

	public PacienteModel(String pili, String perez, int i, String avd_galdos, String s) {
	}

	public PacienteModel(Integer idPaciente, String nombre) {
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

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	@Override
	public String toString() {
		return "Paciente{" +
				"idPaciente=" + idPaciente +
				", nombre='" + nombre + '\'' +
				", apellidos='" + apellidos + '\'' +
				", edad=" + edad +
				", direccion='" + direccion + '\'' +
				", foto='" + foto + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}

	public void setFoto(MultipartFile foto, PacienteModel pacienteModel) {
	}
}
