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

import dao.ResiduoDAO;
import generic.RecursoDuplicado;
import generic.RecursoNoExiste;
import model.Residuo;


@Path("/Residuos")
public class ResiduoRESTController  {

	/**
	 * Retorna un listado de los Residuos guardados en la base de datos.
	 * 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Residuo> getAllResiduos() {
		return ResiduoDAO.getInstance().findAll();
	}
	
	
	/**
	 * Retorna un residuo segun su id pasado como parametro.
	 * 
	 * @param id Identificador unico de un residuo en la base de datos.
	 * 
	 * @return Retorna un Json conteniendo los datos del residuo solicitado
	 */
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
	
	/**
	 * Dado un nombre retorna verdadero o falso segun si se corresponde con un residuo persistido en la base. 
	 *
	 * @param name Un string con el nombre de residuo.
	 */
	@GET
	@Path("/{name}")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean esResiduo(@PathParam("name") String msg) {
		return ResiduoDAO.getInstance().esReciclable(msg);
     
	}

	/**
	 * Da de alta un residuo en la base de datos
	 * 
	 * @param recibe  por POST un Json con los datos de residuo.
	 */
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

	/**
	 * Borra un residuo de la base de Datos conforme el id.
	 *
	 * @param id Identificador de un residuo en la base de datos.
	 */
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteResiduo(@PathParam("id") int id) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Actualiza los datos de un residuo segun su id
	 * 
	 * @param id Identificador de un residuo en la base de datos.
	 * 
	 */
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateResiduo(@PathParam("id") int id,Residuo user) {
		throw new UnsupportedOperationException();
	}


	
}
