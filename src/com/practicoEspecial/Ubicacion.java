package com.practicoEspecial;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ubicacion {
	@Id
	@GeneratedValue
	int id;

	private double latitud;
	private double longitud;
	public Ubicacion() {
		super();
	}
	public Ubicacion(float longitud, float latitud) {
		super();
		this.longitud = longitud;
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double distancia(Ubicacion u) {
		return Math.sqrt(Math.pow(Math.abs(u.getLatitud()-this.getLatitud()), 2)+Math.pow(Math.abs(u.getLongitud()-this.getLongitud()), 2));
	}
	@Override
	public String toString() {
		return "Ubicacion [id=" + id + ", longitud=" + longitud + ", latitud=" + latitud + "]";
	}
	
	
}
