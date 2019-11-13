package model;

/**
 * Esta clase define objetos del tipo geoposicion, las instancias de esta clase no son persistidas
 * en la base de datos, su importancia se basa en el uso de metodos referidoa a la geoposicion.
 */
public class Ubicacion {

	private double latitud;
	private double longitud;
	public Ubicacion() {
		super();
	}
	public Ubicacion(float longitud, float latitud) {
		super();
		this.longitud = longitud;
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	
	/**
	 * Devuelve la distancia desde la instracia misma de una ubicacion 
	 * hasta la ubicacion pasada por parametro. 
	 */
	public double distancia(Ubicacion u) {
		return Math.sqrt(Math.pow(Math.abs(u.getLatitud()-this.getLatitud()), 2)+Math.pow(Math.abs(u.getLongitud()-this.getLongitud()), 2));
	}
	@Override
	public String toString() {
		return "Ubicacion [longitud=" + longitud + ", latitud=" + latitud + "]";
	}
	
	
}
