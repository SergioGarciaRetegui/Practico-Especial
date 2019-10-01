package com.practicoEspecial;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Donacion {


	@Id
	@GeneratedValue
	int id;
	
	@OneToOne
    @JoinColumn(name="residuo_id")
	Residuo reciclable;
	
	int cant;
	
	@OneToOne
    @JoinColumn(name="ong_id")
	Ong ong;
	
	public Donacion() {
	}

	public Donacion(int id, Residuo reciclable, int cant, Ong ong) {
		super();
		this.id = id;
		this.reciclable = reciclable;
		this.cant = cant;
		this.ong = ong;
	}
	public int getId() {
		return this.id;
	}

	public Residuo getReciclable() {
		return reciclable;
	}

	public void setReciclable(Residuo reciclable) {
		this.reciclable = reciclable;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public Ong getOng() {
		return ong;
	}

	public void setOng(Ong ong) {
		this.ong = ong;
	}

}
