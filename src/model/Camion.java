package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 * Define objetos del tipo Camion persistiendo sus datos principales marca, patente, capacidad y geoposicion
 */
@Entity
public class Camion {
	@Id
	@GeneratedValue
	int id;
	
	
	String patente;
	String marca;
	int capacidad;
	int capActual;

    /**
     * Datos de Geoposicion de un Camion
     * 
 	 * latGeoposicion representa la latitud en geoposicion
	 */
	Double latGeoposicion;
	/**
	 * longGeoposicion representa la longitud en geoposicion
	 */
    Double longGeoposicion;
	
	boolean activo;
	

	public Camion() {
		super();
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

	public Double getLatGeoposicion() {
		return latGeoposicion;
	}

	public void setLatGeoposicion(Double latgeoposicion) {
		latGeoposicion = latgeoposicion;
	}

	public Double getLongGeoposicion() {
		return longGeoposicion;
	}

	public void setLongGeoposicion(Double longeoposicion) {
		longGeoposicion = longeoposicion;
	}
    public double geoDistancia(Double lat,Double longi) {
		return Math.sqrt(Math.pow(Math.abs(lat-this.getLatGeoposicion()), 2)+Math.pow(Math.abs(longi-this.getLongGeoposicion()), 2));
	}

	
	@Override
	public String toString() {
		return "Camion [id=" + id + ", patente=" + patente + ", marca=" + marca + ", capacidad=" + capacidad
				+ ", capActual=" + capActual + ", Latgeoposicion=" + latGeoposicion + ", Longeoposicion="
				+ longGeoposicion + ", activo=" + activo + "]";
	}



}
