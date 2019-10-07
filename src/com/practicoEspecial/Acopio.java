package com.practicoEspecial;



import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Acopio {
	@Id
	@GeneratedValue
	int id;
	
	@OneToOne
    @JoinColumn(name="residuo_id")
    Residuo reciclable;
    
	int cant;
	
	Date fechaAcopio;
    
    @OneToOne
    @JoinColumn(name="usuario_id")
    Usuario user;
    
    @OneToOne
    @JoinColumn(name="puntolimpio_id")
	PuntoLimpio puntlimpio;
	
	public Acopio() {
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
	public void setReciclable(int id) {
		Residuo res=ResiduoDAO.getInstance().findById(id);
		this.reciclable = res;
	}
	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}
	public void setFechaAcopio(Date fech) {
	   this.fechaAcopio=fech;	
	}
	public Date getFechaAcopio() {
		return this.fechaAcopio;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public void setUser(int id) {
		Usuario us=UsuarioDAO.getInstance().findById(id);
		this.user = us;
	}
    public PuntoLimpio getPuntlimpio() {
		return puntlimpio;
	}
	public void setPuntlimpio(PuntoLimpio puntolimpio) {
		this.puntlimpio = puntolimpio;
	}
	public void setPuntlimpio(int id) {
		PuntoLimpio pl=PuntoLimpioDAO.getInstance().findById(id);
		this.puntlimpio = pl;
	}

	@Override
	public String toString() {
		return "Acopio [id=" + id + ", reciclable=" + reciclable + ", cant=" + cant + "Kg , fechaAcopio=" + fechaAcopio
				+ ", user=" + user + ", puntlimpio=" + puntlimpio + "]";
	}
		

}
