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

import dao.OngDAO;
import generic.RecursoDuplicado;
import generic.RecursoNoExiste;
import model.Ong;


@Path("/Ongs")
public class OngRESTController {

	
	/**
	 * Retorna un listado de las ONGs guardados en la base de datos.
	 * 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ong> getAllOngs() {
		return OngDAO.getInstance().findAll();
	}
	
	/**
	 * Retorna una ONG segun su id pasado como parametro.
	 * 
	 * @param id Identificador unico de una ONG en la base de datos.
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Ong getOngById(@PathParam("id") String msg) {
		int id = Integer.valueOf(msg);
		Ong ong = OngDAO.getInstance().findById(id);
		if(ong!=null)
			return ong;
		else
			throw new RecursoNoExiste(id);
	}
	
	/**
	 * Da de alta una ONG en la base de datos
	 * 
	 * @param recibe por POST un Json con los datos de una ONG.
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createOng(Ong ong) {
		Ong result= OngDAO.getInstance().persist(ong);
		if(result==null) {
			throw new RecursoDuplicado(ong.getId());
		}else {
			return Response.status(201).entity(ong).build();
		}
	}

	/**
	 * Borra una ONG de la base de Datos conforme el id.
	 *
	 * @param id Identificador de una ONG en la base de datos.
	 */
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteOng(@PathParam("id") int id) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Actualiza los datos de una ONG segun su id
	 * 
	 * @param id Identificador de una ONG en la base de datos.
	 * 
	 */
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateOng(@PathParam("id") int id,Ong ong) {
		throw new UnsupportedOperationException();
	}

	
}
