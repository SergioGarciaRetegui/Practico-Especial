package com.practicoEspecial;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Residuo {

	@Id
	@GeneratedValue
	int id;
	
	String nombre;
	double valorKg;

	public Residuo() {
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
	@Override
	public String toString() {
		return "Residuo [id=" + id + ", nombre=" + nombre + ", ValorKg=" + valorKg + "]";
	}
	public double getValorKg() {
		return valorKg;
	}
	public void setValorKg(double valorKg) {
		this.valorKg = valorKg;
	}

}
