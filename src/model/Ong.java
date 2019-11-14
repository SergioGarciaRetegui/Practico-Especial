package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * Define objetos que representan las Ong beneficiadas por los residuos reciclados.
 */
@Entity
public class Ong {

	@Id
	@GeneratedValue
	int id;

	String nombre;

	public Ong() {
		super();
	}

	public Ong(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Ong [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
