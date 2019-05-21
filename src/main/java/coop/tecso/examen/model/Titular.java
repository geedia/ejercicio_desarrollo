package coop.tecso.examen.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Titular implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	private Long CUIT;
	
	@Column(length=80)
	private String nombre;
	
	@Column(length=250)
	private String apellido;
	
	@Column 
	private Long dni;
	
	@Column(length=100)
	private String razon_social;
	
	@Column(length=4)
	private Long anio;
	
	@Column(length=1,nullable=false)
	private String tipo_titular;

	

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

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public Long getAnio() {
		return anio;
	}

	public void setAnio(Long anio) {
		this.anio = anio;
	}

	public String getTipo_titular() {
		return tipo_titular;
	}

	public void setTipo_titular(String tipo_titular) {
		this.tipo_titular = tipo_titular;
	}

	public Long getCUIT() {
		return CUIT;
	}

	public void setCUIT(Long cUIT) {
		CUIT = cUIT;
	}
	
	
	
}
