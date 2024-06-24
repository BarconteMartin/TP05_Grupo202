package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Component 
@Data
@Entity

public class Docente {
	@Id
	private String legajo;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private boolean estado;
	
	public String getLegajo() {
		return legajo;
	}
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setEstado(boolean b) {
		// TODO Auto-generated method stub
		
	}
}