package com.practicoEspecial;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PuntoLimpio {

	@Id
	@GeneratedValue
	int id;

	String nombre;
	int kgTope;
	int KgAcumulados;
	String Calle;
	int numero;

	@OneToOne
    @JoinColumn(name="ubicacion_id")
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
	public String getCalle() {
		return Calle;
	}
	public void setCalle(String calle) {
		Calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		return "PuntoLimpio [id=" + id + ", nombre=" + nombre + ", kgTope=" + kgTope + ", KgAcumulados=" + KgAcumulados
				+ ", Calle=" + Calle + ", numero=" + numero + ", geoposicion=" + geoposicion + "]";
	}
	
}
