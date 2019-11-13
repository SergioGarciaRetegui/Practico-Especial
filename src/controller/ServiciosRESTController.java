package controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.AcopioDAO;
import dao.DonacionDAO;
import dao.OngDAO;
import dao.PuntoLimpioDAO;
import dao.RecoleccionDAO;
import dao.ResiduoDAO;
import dao.UsuarioDAO;
import generic.RecursoNoExiste;
import generic.Resultado;
import generic.DataReturn;
import model.Acopio;
import model.Ong;
import model.PuntoLimpio;
import model.Recoleccion;
import model.Residuo;
import model.Usuario;

@Path("/servicios")
public class ServiciosRESTController {

	/**
	 * Retorna un listado de acopios realizados por un usuario 
	 * 
	 * @param id  Identificador de un Usuario en la Base de datos
	 * 
	 */
	@GET
	@Path("/usuario/{id}/acopios")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Acopio> AcopiosPorUsuario(@PathParam("id") String msg) {
		int id = Integer.valueOf(msg);
		List<Acopio> result= AcopioDAO.getInstance().findByIdUsuario(id);
		if(result!=null)
			return result;
		else
			throw new RecursoNoExiste(id);
	}
	
	/**
	 * Retorna un listado de acopios realizados por un usuario dentro de un rango de fechas. 
	 * 
	 * @param id  Identificador de un Usuario en la Base de datos
	 * @param FechI Fecha desde donde comienza la busqueda de acopios realizados
	 * @param FechF Fecha hasta donde termina la busqueda de acopios realizados
	 * 
	 */
	@GET
	@Path("/usuario/{id}/fechaI/{fecIn}/fechaF/{fecF}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Acopio> AcopiosPorUsuarioAndFechas(@PathParam("id") String msg,@PathParam("fecIn") String FeI,@PathParam("fecF") String FeF) {
		int id = Integer.valueOf(msg);
		System.out.println(FeI);
		System.out.println(FeF);
		Date FechaIni= Date.valueOf(FeI);
		Date FechaFin= Date.valueOf(FeF);
		List<Acopio> result= AcopioDAO.getInstance().findByIdUsuarioAndfechas(id, FechaIni, FechaFin);
		if(result!=null)
			return result;
		else
			throw new RecursoNoExiste(id);
	}

	/**
	 * Retorna una lista con los lugares de recoleccion mas cercanos segun la geolocalizacion de un usuario
	 * 
	 * @param id  Identificador de un Usuario en la Base de datos
	 * 
	 */
	@GET
	@Path("/usuario/{id}/lugares")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Recoleccion> LugaresAcopioPorUsuario(@PathParam("id") String msg){
		int id = Integer.valueOf(msg);
		List<Recoleccion> result= UsuarioDAO.getInstance().recoleccionesPorGeolocalizacion(id);
		if(result!=null)
			return result;
		else
			throw new RecursoNoExiste(id);
	}
		
	/**
	 * Retorna una tupla con el par nombre de usuario y cantidad en kg depositados por el usuario. 
	 * 
	 * @param id  Identificador de un Usuario en la Base de datos
	 * 
	 */
	@GET
	@Path("/usuario/{id}/ahorro")
	@Produces(MediaType.APPLICATION_JSON)
	public DataReturn ahorroByUser(@PathParam("id") String msg) {
		int id = Integer.valueOf(msg);
		int cant=0;
		DataReturn result=new DataReturn();
		Usuario us=UsuarioDAO.getInstance().findById(id);
		if (us!=null) {
		List<Acopio> acopios =AcopioDAO.getInstance().findByIdUsuario(id);
		if (acopios.size()>0) {
			Iterator itacopio=acopios.iterator();
			Acopio aux;
			while(itacopio.hasNext()) {
				aux=(Acopio)itacopio.next();
				cant+=aux.getCant();
			}
			result.setString(us.getNombre()+us.getApellido());
			result.setValue(cant);
			return result;
			}
		else {
			result.setString(us.getNombre()+us.getApellido());
			result.setValue(cant);
			return result;
		}
		}
		else {
			throw new RecursoNoExiste(id);
		}
	}

	/**
	 * Retorna una tupla con el par nombre de usuario y cantidad en kg depositados por el usuario dentro de un rango de fechas. 
	 * 
	 * @param id  Identificador de un Usuario en la Base de datos
	 * @param FechI Fecha desde donde comienza la busqueda de acopios realizados
	 * @param FechF Fecha hasta donde termina la busqueda de acopios realizados
	 */
	@GET
	@Path("/usuario/{id}/fechaI/{fecIn}/fechaF/{fecF}/ahorro")
	@Produces(MediaType.APPLICATION_JSON)
	public DataReturn AhorroByIdUserAndFechas(@PathParam("id") String msg,@PathParam("fecIn") String FeI,@PathParam("fecF") String FeF){
		int id = Integer.valueOf(msg);
		Date FechaIni= Date.valueOf(FeI);
		Date FechaFin= Date.valueOf(FeF);
		DataReturn result= new DataReturn();
		Usuario user=UsuarioDAO.getInstance().findById(id);
		int cant=0;
		if (user!=null) {
			List<Acopio> acopios =AcopioDAO.getInstance().findByIdUsuarioAndfechas(id,FechaIni,FechaFin);
			if (acopios.size()>0) {
				Iterator itacopio=acopios.iterator();
				Acopio aux;
				while(itacopio.hasNext()) {
					aux=(Acopio)itacopio.next();
					cant+=aux.getCant();
				}
				result.setString(user.getNombre()+user.getApellido());
				result.setValue(cant);
				return result;
			}
			else {
				result.setString(user.getNombre()+user.getApellido());
				result.setValue(cant);
				return result;
			}
		}
		else {
			throw new RecursoNoExiste(id);
		}
	}
	
	/**
	 * Retorna los residuos realizados por un usuario y el equivalente en dinero
	 * 
	 * @param id Identificador de usuario.
	 * 
	 * @return Hastable <String, Integer> retorna un conjunto de tuplas residuo - Importe
	 */
	@GET
	@Path("/usuario/{id}/aportes")
	@Produces(MediaType.APPLICATION_JSON)
	public Hashtable<String, Integer> AporteByIdUser(@PathParam("id") String msg){
		int id = Integer.valueOf(msg);
        Hashtable<String, Integer> result=UsuarioDAO.getInstance().aporteParaOngs(id);
        return result;
	}
	
	/**
	 * Retorna una lista con los nombres de los residuos procesados por un punto limpio dentro de un rango de fechas 
	 * 
	 *@param id Identificador de Punto Limpio.
	 *@param fecIn Fecha de inicio de la busqueda formato: YYYY/MM/DD
	 *@param FechF  Fecha final de la busqueda Formato YYYY/MM/DD
	 */
	@GET
	@Path("/puntolimpio/{id}/fechaI/{fecIn}/fechaF/{fecF}/depositos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> puntoLimpioAndFechas(@PathParam("id") String msg,@PathParam("fecIn") String FeI,@PathParam("fecF") String FeF){
		int id = Integer.valueOf(msg);
		Date FechaIni= Date.valueOf(FeI);
		Date FechaFin= Date.valueOf(FeF);
		ArrayList<String> result= new ArrayList();
		PuntoLimpio PL=PuntoLimpioDAO.getInstance().findById(id);
	    if(PL!=null) {
	    	List<Residuo> residuos=AcopioDAO.getInstance().findByIdPuntoLimpioAndfechas(7, Date.valueOf("2019-01-01"), Date.valueOf("2019-12-01"));
	    	if(residuos.size()>0) {
	    		Iterator it=residuos.iterator();
	    		Residuo aux;
	    		while(it.hasNext()) {
	    			aux=(Residuo)it.next();
	    			result.add(aux.getNombre());
	    		}
	    		return result;
	    	}
	    	else {
	    		result.add("El punto limpio no tiene residuos Reciclados");
	    		return result;
	    	}
	    }
	    else
	    	throw new RecursoNoExiste(id);
	}
	
	/**
	 * Dado un residuos por nombre retorna si este residuo es procesado por los puntos limpios
	 * como reciclable
	 * 
	 * @param resid es un String con el nombre de un residuo.
	 */
	@GET
	@Path("/residuo/{resid}/esReciclabe")
	@Produces(MediaType.APPLICATION_JSON)
    public boolean recursoReciclable(@PathParam("resid") String msg) {
	 if (ResiduoDAO.getInstance().esReciclable("Vidrio")) {
		return true;	
		}
	else {
		return false;
		}

	}
	
	/**
	 * Dado un Punto Limpio por su ID verifica si este llego al limite de su volumen de almacenamiento  
	 * 
	 * @param id Identificador de Punto Limpio.
	 */
	@GET
	@Path("/puntolimpio/{id}/lleno")
	@Produces(MediaType.APPLICATION_JSON)
    public boolean PuntoLimpioLleno(@PathParam("id") String msg) {
     int id = Integer.valueOf(msg);
		PuntoLimpio pl=PuntoLimpioDAO.getInstance().findById(7);
		if (pl!=null) {
			if (PuntoLimpioDAO.getInstance().capacidadAlcanzada(7)) {
				return true;
			}
			else {
				return false;
			}

		}
		else
			throw new RecursoNoExiste(id);
	}
	
	/**
	 * Retorna el equivalente en dinero obtenido por una Ong respecto a los residuos recibidos en concepto de donacion
	 * 
	 * @param id Identificador de Ong.
	 * 
	 * 
	 */
	
	@GET
	@Path("/ong/{id}/ayuda")
	@Produces(MediaType.APPLICATION_JSON)
	public DataReturn ayudaOng(@PathParam("id") String msg) {
	  int id = Integer.valueOf(msg);
	  Ong org= OngDAO.getInstance().findById(id);
	  if (org!=null) {
		  DataReturn result= new DataReturn();
		  result.setValue(DonacionDAO.getInstance().findAyudaAOng(id).intValue());
		  result.setString("importe");
		  return result;		  
	  }
	  else
		throw new RecursoNoExiste(id);
	}
	
	/**
	 *Retorna el equivalente en dinero obtenido por una Ong respecto a los residuos recibidos en concepto de donacion
	 *dentro de un rango definido por fechaInicio y fechaFin
	 * 
	 *@param id Identificador de Ong.
	 *@param fecIn Fecha de inicio de la busqueda formato: YYYY/MM/DD
	 *@param FechF  Fecha final de la busqueda Formato YYYY/MM/DD
	 */
	@GET
	@Path("/ong/{id}/fechaI/{fecIn}/fechaF/{fecF}/ayuda")
	@Produces(MediaType.APPLICATION_JSON)
	public DataReturn ayudaOngFechas(@PathParam("id") String msg,@PathParam("fecIn") String FeI,@PathParam("fecF") String FeF){
		int id = Integer.valueOf(msg);
		Date FechaIni= Date.valueOf(FeI);
		Date FechaFin= Date.valueOf(FeF);
		  Ong org= OngDAO.getInstance().findById(id);
		  if (org!=null) {
			  DataReturn result= new DataReturn();
			  result.setValue(DonacionDAO.getInstance().findAyudaAOngByFecha(id, FechaIni, FechaFin).intValue());
			  result.setString("importe");
			  return result;		  
		  }
		  else
			throw new RecursoNoExiste(id);
		}
	
	/**
	 * Retorna la cantidad de residuos procesados por todos los puntos limpios
	 * 
	 */
	@GET
	@Path("/procesado")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Resultado> residuosProcesador(){
		return AcopioDAO.getInstance().TotalResiduosProcesados();
	}

	/**
	 * Retorna la cantidad de residuos procesados dentro de un rango de fechas
	 * @param fecIn Fecha de inicio de la busqueda formato: YYYY/MM/DD
	 * @param FechF  Fecha final de la busqueda Formato YYYY/MM/DD
	 */
	
	@GET
	@Path("/procesado/fechaI/{fecIn}/fechaF/{fecF}/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Resultado> residuosProcesadorByFecha(@PathParam("fecIn") String FeI,@PathParam("fecF") String FeF){
		Date fechaI= Date.valueOf(FeI);
		Date fechaF= Date.valueOf(FeF);
		return AcopioDAO.getInstance().TotalResiduosProcesadosByFecha(fechaI, fechaF);
	}
	
	/**
	 * Retorna una lista ordenada de mayor a menor de punto limpios segun la cantidad de residuos
	 * procesados, el obejto devuelto tiene el siguiente formato:  
	 * @Resultado:
	 * campo: contiene el nombre de la entidad a devolver, en este caso Punto Limpio
	 * valorCampo: Identifica la entidad devuelta por campo.
	 * campoValor:Identifica el criterio por el cual clasifica la entidad devuelta en campo.
	 * valor:Contiene el valor por el cual es clasificado la entidad campo.
	 * 
	 */
	@GET
	@Path("/ranking")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Resultado> rankingPL(){
		return AcopioDAO.getInstance().RankingPL();
	}
	
	

	
}