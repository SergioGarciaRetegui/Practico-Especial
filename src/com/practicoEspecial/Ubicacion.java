package com.practicoEspecial;

public class Ubicacion {

		private float longitud;
	private float latitud;
	public Ubicacion() {
		super();
	}
	public Ubicacion(float longitud, float latitud) {
		super();
		this.longitud = longitud;
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	public float getLatitud() {
		return latitud;
	}
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	public double distancia(Ubicacion u) {
		return Math.sqrt(Math.pow(Math.abs(u.getLatitud()-this.getLatitud()), 2)+Math.pow(Math.abs(u.getLongitud()-this.getLongitud()), 2));
	}
	@Override
	public String toString() {
		return "Ubicacion [longitud=" + longitud + ", latitud=" + latitud + "]";
	}
	
	
}
