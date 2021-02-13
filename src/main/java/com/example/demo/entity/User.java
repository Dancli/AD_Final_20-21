package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class User {
	
	@Id
	@GeneratedValue
	private int idUsuario;
	
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	
	@Column(name = "password", nullable = false)
	@Size(max = 100)
	private String password;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@Column(name = "role")
	private String role;
	
	private String token;
	
	public User() {
		
	}

	public User(int idUsuario, String username, @Size(max = 100) String password, boolean enabled, String role) {
		super();
		this.idUsuario = idUsuario;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "User [idUsuario=" + idUsuario + ", username=" + username + ", password=" + password + ", enabled="
				+ enabled + ", role=" + role + "]";
	}
	
}
