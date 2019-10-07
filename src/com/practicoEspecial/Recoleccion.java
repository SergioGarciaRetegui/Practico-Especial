package com.practicoEspecial;

import java.sql.Time;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Recoleccion {


	@Id
	@GeneratedValue
	int id;
	
	Time horaInic;
	Time horaFin;

	String dia;

    @OneToOne 	
    @JoinColumn(name="camion_id")
	Camion camionRecolector;
	
    @OneToOne
    @JoinColumn(name="puntoLimpio_id")
	PuntoLimpio puntoRecoleccion;
	
	public Recoleccion() {
		// TODO Auto-generated constructor stub
	}

/*	public Recoleccion(Date horaInic, Date horaFin, String dia, PuntoLimpio pointL) {
		super();
		this.horaInic = horaInic;
		this.horaFin = horaFin;
		this.dia = dia;
		PointL = pointL;
	}*/

	public Time getHoraInic() {
		return horaInic;
	}

	public void setHoraInic(Time horaInic) {
		this.horaInic = horaInic;
	}

	public Time getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public PuntoLimpio getPuntoRecoleccion() {
		return puntoRecoleccion;
	}

	public void setPuntoRecoleccion(PuntoLimpio puntoRecoleccion) {
		this.puntoRecoleccion = puntoRecoleccion;
	}
	public void setPuntoRecoleccion(int id) {
		PuntoLimpio pl=PuntoLimpioDAO.getInstance().findById(id);
		this.puntoRecoleccion = pl;
	}

	public Camion getCamionRecolector() {
		return camionRecolector;
	}

	public void setCamionRecolector(Camion camionRecolector) {
		this.camionRecolector = camionRecolector;
	}

	public void setCamionRecolector(int id) {
		Camion aux=CamionDAO.getInstance().findById(id);
		this.camionRecolector = aux;
	}

	@Override
	public String toString() {
		return "Recoleccion [id=" + id + ", horaInic=" + horaInic + ", horaFin=" + horaFin + ", dia=" + dia
				+ ", CamionRecolector=" + camionRecolector + ", puntoRecoleccion=" + puntoRecoleccion + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
