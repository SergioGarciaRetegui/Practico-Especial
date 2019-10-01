package com.practicoEspecial;
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

@Path("/acopios")
public class AcopioRESTController {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Acopio> getAlls() {
		return AcopioDAO.getInstance().findAll();
	}
	
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

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) {
		throw new UnsupportedOperationException();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id,Acopio acopio) {
		throw new UnsupportedOperationException();
	}

	public class RecursoDuplicado extends WebApplicationException {
	     public RecursoDuplicado(int id) {
	         super(Response.status(Response.Status.CONFLICT)
	             .entity("El recurso con ID "+id+" ya existe").type(MediaType.TEXT_PLAIN).build());
	     }
	}
	
	public class RecursoNoExiste extends WebApplicationException {
	     public RecursoNoExiste(int id) {
	         super(Response.status(Response.Status.NOT_FOUND)
	             .entity("El recurso con id "+id+" no fue encontrado").type(MediaType.TEXT_PLAIN).build());
	     }
	}
	
}
