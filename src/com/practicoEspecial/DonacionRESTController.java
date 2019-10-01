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

@Path("/Donacions")

public class DonacionRESTController {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Donacion> getAllDonacions() {
		return DonacionDAO.getInstance().findAll();
	}
	
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

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteDonacion(@PathParam("id") int id) {
		throw new UnsupportedOperationException();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateDonacion(@PathParam("id") int id,Donacion don) {
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
