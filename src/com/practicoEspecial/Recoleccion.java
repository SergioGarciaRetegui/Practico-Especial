package com.practicoEspecial;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Recoleccion {


	@Id
	@GeneratedValue
	int Id;
	
	Date horaInic;
	Date horaFin;
	String dia;
	
	@OneToOne
    @JoinColumn(name="puntolimpio_id")
	PuntoLimpio PointL;
	
	public Recoleccion() {
		// TODO Auto-generated constructor stub
	}

	public Recoleccion(int id, Date horaInic, Date horaFin, String dia, PuntoLimpio pointL) {
		super();
		Id = id;
		this.horaInic = horaInic;
		this.horaFin = horaFin;
		this.dia = dia;
		PointL = pointL;
	}

	public Date getHoraInic() {
		return horaInic;
	}

	public void setHoraInic(Date horaInic) {
		this.horaInic = horaInic;
	}

	public Date getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public PuntoLimpio getPointL() {
		return PointL;
	}

	public void setPointL(PuntoLimpio pointL) {
		PointL = pointL;
	}

}
