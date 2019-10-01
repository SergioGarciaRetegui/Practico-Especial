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


@Path("/Residuos")
public class ResiduoRESTController  {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Residuo> getAllResiduos() {
		return ResiduoDAO.getInstance().findAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Residuo getResiduoById(@PathParam("id") String msg) {
		int id = Integer.valueOf(msg);
		Residuo res = ResiduoDAO.getInstance().findById(id);
		if(res!=null)
			return res;
		else
			throw new RecursoNoExiste(id);
	}

	@GET
	@Path("/{name}")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean esResiduo(@PathParam("name") String msg) {
		return ResiduoDAO.getInstance().esReciclable(msg);
     
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createResiduo(Residuo res) {
		Residuo result= ResiduoDAO.getInstance().persist(res);
		if(result==null) {
			throw new RecursoDuplicado(res.getId());
		}else {
			return Response.status(201).entity(res).build();
		}
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteResiduo(@PathParam("id") int id) {
		throw new UnsupportedOperationException();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateResiduo(@PathParam("id") int id,Residuo user) {
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
