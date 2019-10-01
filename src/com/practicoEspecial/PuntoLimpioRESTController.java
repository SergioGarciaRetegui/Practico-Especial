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

@Path("/PuntosLimpios")
public class PuntoLimpioRESTController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PuntoLimpio> getAllPuntoLimpios() {
		return PuntoLimpioDAO.getInstance().findAll();
	}
	
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

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePuntoLimpio(@PathParam("id") int id) {
		throw new UnsupportedOperationException();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePuntoLimpio(@PathParam("id") int id,PuntoLimpio pl) {
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
