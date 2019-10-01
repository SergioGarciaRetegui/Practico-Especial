package com.practicoEspecial;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {
	@Id
	@GeneratedValue
	int id;
	
	String nombre;	
	String apellido;
	int dni;
    String email;
    String calle;
    int numero;
    float latitud;
    float longitud;
    
    public Usuario() {
    }
    public Usuario(int id, int dni,String nom, String apellido, String email, String calle, int num, float lat, float Long) {
      this.id=id;
      this.dni=dni;
      this.nombre=nom;
      this.apellido=apellido;
      this.email=email;
      this.calle=calle;
      this.numero=num;
      this.latitud=lat;
      this.longitud=Long;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public float getLatitud() {
		return latitud;
	}
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	public float getLongitud() {
		return longitud;
	}
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", email="
				+ email + ", calle=" + calle + ", numero=" + numero + ", latitud=" + latitud + ", longitud=" + longitud
				+ "]";
	}

}
