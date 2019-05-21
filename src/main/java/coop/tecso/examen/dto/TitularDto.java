package coop.tecso.examen.dto;

import java.io.Serializable;

public class TitularDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String CUIT;
	private String nombre;
	private String apellido;
	private Long dni;
	private String razon_social;
	private Long anio;
	private String tipo_titular;
	public String getCUIT() {
		return CUIT;
	}
	public void setCUIT(String CUIT) {
		this.CUIT = CUIT;
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
	public Long getDni() {
		return dni;
	}
	public void setDNI(Long dni) {
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
}
