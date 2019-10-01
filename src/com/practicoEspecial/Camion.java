package com.practicoEspecial;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity

public class Camion {
	@Id
	@GeneratedValue
	int id;
	
	String patente;
	String marca;
	long latitud;
	long longitud;
	boolean activo;

	public Camion() {
		super();
	}

	public Camion(int id, String patente, String marca, long latitud, long longitud, boolean activo) {
		super();
		this.id = id;
		this.patente = patente;
		this.marca = marca;
		this.latitud = latitud;
		this.longitud = longitud;
		this.activo = activo;
	}
	
	public int getId() {
		return this.id;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public long getLatitud() {
		return latitud;
	}
	public void setLatitud(long latitud) {
		this.latitud = latitud;
	}
	public long getLongitud() {
		return longitud;
	}
	public void setLongitud(long longitud) {
		this.longitud = longitud;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	

}
