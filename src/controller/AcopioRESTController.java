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

import dao.AcopioDAO;
import generic.RecursoDuplicado;
import generic.RecursoNoExiste;
import model.Acopio;

@Path("/acopios")
public class AcopioRESTController {

	
	/**
	 * Retorna un listado de los Acopios guardados en la base de datos.
	 * 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Acopio> getAlls() {
		return AcopioDAO.getInstance().findAll();
	}
	
	/**
	 * Retorna un Acopio segun su id pasado como parametro.
	 * 
	 * @param id Identificador unico de un Acopio en la base de datos.
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Acopio getById(@PathParam("id") String msg) {
		int id = Integer.valueOf(msg);
		Acopio acopio = AcopioDAO.getInstance().findById(id);
		if(acopio!=null)
			return acopio;
		else
			throw new RecursoNoExiste(id);
	}
	
	/**
	 * Da de alta un Acopio en la base de datos
	 * 
	 * @param recibe por POST un Json con los datos de Acopio.
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Acopio acopio) {
		Acopio result= AcopioDAO.getInstance().persist(acopio);
		if(result==null) {
			throw new RecursoDuplicado(acopio.getId());
		}else {
			return Response.status(201).entity(acopio).build();
		}
	}

	/**
	 * Retorna un listado de Acopios segun el id de un usuario pasado como parametro.
	 * 
	 * @param id Identificador unico de un Usuario en la base de datos.
	 */
	@GET
	@Path("/usuario/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Acopio> getByIdUsuario(@PathParam("id") String msg) {
		int id = Integer.valueOf(msg);
		List<Acopio> result= AcopioDAO.getInstance().findByIdUsuario(id);
		if(result!=null)
			return result;
		else
			throw new RecursoNoExiste(id);
	}

	/**
	 * Borra un Acopio de la base de Datos conforme el id.
	 *
	 * @param id Identificador de un Acopio en la base de datos.
	 */
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Actualiza los datos de un Acopio segun su id
	 * 
	 * @param id Identificador de un Acopio en la base de datos.
	 * 
	 */
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id,Acopio acopio) {
		throw new UnsupportedOperationException();
	}
	
}
