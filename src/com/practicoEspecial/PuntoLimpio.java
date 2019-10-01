package com.practicoEspecial;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PuntoLimpio {

	@Id
	@GeneratedValue
	int id;

	String nombre;
	int kgTope;
	float longitud;
	float latitud;

	public PuntoLimpio() {
		
	}
	public int getId() {
		return this.id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setKgTope(int kgTope) {
		this.kgTope=kgTope;
	}

	public int getKgTope() {
		return this.kgTope;
	}
	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	@Override
	public String toString() {
		return "PuntoLimpio [id=" + id + ", nombre=" + nombre + ", longitud=" + longitud + ", latitud=" + latitud + "]";
	}
	
}
