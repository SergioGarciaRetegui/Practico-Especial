package com.practicoEspecial;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity

public class Camion {
	@Id
	@GeneratedValue
	int id;
	
	String patente;
	String marca;
	int capacidad;
	int capActual;

	@OneToOne
    @JoinColumn(name="ubicacion_id")
	Ubicacion geoposicion;
	boolean activo;

	public Camion() {
		super();
	}

	public Camion(String patente, String marca, int capacidad, int capActual, Ubicacion geoposicion, boolean activo) {
		super();
		this.patente = patente;
		this.marca = marca;
		this.capacidad = capacidad;
		this.capActual = capActual;
		this.geoposicion = geoposicion;
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
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getCapActual() {
		return capActual;
	}

	public void setCapActual(int capActual) {
		this.capActual += capActual;
	}
	public void setCapActualaCero() {
		this.capActual =0;
	}

	public Ubicacion getGeoposicion() {
		return geoposicion;
	}

	public void setGeoposicion(Ubicacion geoposicion) {
		this.geoposicion = geoposicion;
	}

	@Override
	public String toString() {
		return "Camion [id=" + id + ", patente=" + patente + ", marca=" + marca + ", capacidad=" + capacidad
				+ ", capActual=" + capActual + ", geoposicion=" + geoposicion + ", activo=" + activo + "]";
	}
	

}
