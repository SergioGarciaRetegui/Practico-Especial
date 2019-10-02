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
	int KgAcumulados;
	Ubicacion geoposicion;

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
	public int getKgAcumulados() {
		return KgAcumulados;
	}
	public void setKgAcumulados(int kgAcumulados) {
		KgAcumulados += kgAcumulados;
	}
	public void setKgAcumuladosaCero() {
		this.KgAcumulados=0;
	}
	public Ubicacion getGeoposicion() {
		return geoposicion;
	}
	public void setGeoposicion(Ubicacion geoposicion) {
		this.geoposicion = geoposicion;
	}
	@Override
	public String toString() {
		return "PuntoLimpio [id=" + id + ", nombre=" + nombre + ", kgTope=" + kgTope + ", KgAcumulados=" + KgAcumulados
				+ ", geoposicion=" + geoposicion + "]";
	}
	
}
