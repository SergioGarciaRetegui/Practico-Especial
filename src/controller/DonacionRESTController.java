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

import dao.DonacionDAO;
import generic.RecursoDuplicado;
import generic.RecursoNoExiste;
import model.Donacion;

@Path("/Donacions")

public class DonacionRESTController {

	
	/**
	 * Retorna un listado de las Donaciones guardadas en la base de datos.
	 * 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Donacion> getAllDonacions() {
		return DonacionDAO.getInstance().findAll();
	}
	
	/**
	 * Retorna una Donacion segun su id pasado como parametro.
	 * 
	 * @param id Identificador unico de una Donacion en la base de datos.
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Donacion getDonacionById(@PathParam("id") String msg) {
		int id = Integer.valueOf(msg);
		Donacion don = DonacionDAO.getInstance().findById(id);
		if(don!=null)
			return don;
		else
			throw new RecursoNoExiste(id);
	}
	
	/**
	 * Da de alta una donacion en la base de datos
	 * 
	 * @param recibe por POST un Json con los datos de una Donacion.
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createDonacion(Donacion don) {
		Donacion result= DonacionDAO.getInstance().persist(don);
		if(result==null) {
			throw new RecursoDuplicado(don.getId());
		}else {
			return Response.status(201).entity(don).build();
		}
	}

	/**
	 * Borra una Donacion de la base de Datos conforme el id.
	 *
	 * @param id Identificador de una Donacion en la base de datos.
	 */
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteDonacion(@PathParam("id") int id) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Actualiza los datos de una Donacion segun su id
	 * 
	 * @param id Identificador de una Donacion en la base de datos.
	 * 
	 */
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateDonacion(@PathParam("id") int id,Donacion don) {
		throw new UnsupportedOperationException();
	}

	
}
