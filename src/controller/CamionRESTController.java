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

import dao.CamionDAO;
import generic.RecursoDuplicado;
import generic.RecursoNoExiste;
import model.Camion;

@Path("/Camiones")
public class CamionRESTController {

	
	/**
	 * Retorna un listado de los Camiones guardados en la base de datos.
	 * 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Camion> getAllCamions() {
		return CamionDAO.getInstance().findAll();
	}
	
	/**
	 * Retorna un Camion segun su id pasado como parametro.
	 * 
	 * @param id Identificador unico de un Camion en la base de datos.
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Camion getCamionById(@PathParam("id") String msg) {
		int id = Integer.valueOf(msg);
		Camion camion = CamionDAO.getInstance().findById(id);
		if(camion!=null)
			return camion;
		else
			throw new RecursoNoExiste(id);
	}
	
	/**
	 * Da de alta un Camion en la base de datos
	 * 
	 * @param recibe por POST un Json con los datos de Camion.
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCamion(Camion camion) {
		Camion result= CamionDAO.getInstance().persist(camion);
		if(result==null) {
			throw new RecursoDuplicado(camion.getId());
		}else {
			return Response.status(201).entity(camion).build();
		}
	}

	/**
	 * Borra un Camion de la base de Datos conforme el id.
	 *
	 * @param id Identificador de un Camion en la base de datos.
	 */
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCamion(@PathParam("id") int id) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Actualiza los datos de un Camion segun su id
	 * 
	 * @param id Identificador de un Camion en la base de datos.
	 * 
	 */
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCamion(@PathParam("id") int id,Camion user) {
		throw new UnsupportedOperationException();
	}
	
	
}
