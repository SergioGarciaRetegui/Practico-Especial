package controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.PuntoLimpioDAO;
import generic.RecursoDuplicado;
import generic.RecursoNoExiste;
import model.PuntoLimpio;

@Path("/PuntosLimpios")
public class PuntoLimpioRESTController {
	
	/**
	 * Retorna un listado de los Punto Limpios guardados en la base de datos.
	 * 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PuntoLimpio> getAllPuntoLimpios() {
		return PuntoLimpioDAO.getInstance().findAll();
	}
	
	/**
	 * Retorna un Punto Limpio segun su id pasado como parametro.
	 * 
	 * @param id Identificador unico de un Punto Limpio en la base de datos.
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public PuntoLimpio getPuntoLimpioById(@PathParam("id") String msg) {
		int id = Integer.valueOf(msg);
		PuntoLimpio pl = PuntoLimpioDAO.getInstance().findById(id);
		if(pl!=null)
			return pl;
		else
			throw new RecursoNoExiste(id);
	}
	
	/**
	 * Da de alta un Punto Limpio en la base de datos
	 * 
	 * @param recibe un por POST un Json con los datos de Punto Limpio.
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createPuntoLimpio(PuntoLimpio pl) {
		PuntoLimpio result= PuntoLimpioDAO.getInstance().persist(pl);
		if(result==null) {
			throw new RecursoDuplicado(pl.getId());
		}else {
			return Response.status(201).entity(pl).build();
		}
	}

	/**
	 * Borra un Punto Limpio de la base de Datos conforme el id.
	 *
	 * @param id Identificador de un Punto Limpio en la base de datos.
	 */
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePuntoLimpio(@PathParam("id") int id) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Actualiza los datos de un Punto limpio segun su id
	 * 
	 * @param id Identificador de un Punto Limpio en la base de datos.
	 * 
	 */
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePuntoLimpio(@PathParam("id") int id,PuntoLimpio pl) {
		throw new UnsupportedOperationException();
	}
	
	
}
