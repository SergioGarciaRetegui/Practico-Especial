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

import dao.UsuarioDAO;
import model.Usuario;
import generic.RecursoNoExiste;
import generic.RecursoDuplicado;


@Path("/usuarios")
public class UsuarioRESTController {

	/**
	 * Retorna un listado de los Usuarios guardados en la base de datos.
	 * 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getAllUsuarios() {
		return UsuarioDAO.getInstance().findAll();
	}

	/**
	 * Retorna un usuario segun su id pasado como parametro.
	 * 
	 * @param id Identificador unico de un usuario en la base de datos.
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUsuarioById(@PathParam("id") String msg) {
		int id = Integer.valueOf(msg);
		Usuario user = UsuarioDAO.getInstance().findById(id);
		if(user!=null)
			return user;
		else
			throw new RecursoNoExiste(id);
	}

	/**
	 * Da de alta un usuario en la base de datos
	 * 
	 * @param recibe por POST un Json con los datos de usuario.
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUsuario(Usuario user) {
		Usuario result= UsuarioDAO.getInstance().persist(user);
		if(result==null) {
			throw new RecursoDuplicado(user.getId());
		}else {
			return Response.status(201).entity(user).build();
		}
	}

	/**
	 * Borra un usuario de la base de Datos conforme el id.
	 *
	 * @param id Identificador de un usuario en la base de datos.
	 */
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUsuario(@PathParam("id") int id) {
		boolean res=UsuarioDAO.getInstance().delete(id);
		if (res) {
			return Response.status(201).entity("usuario borrado").build();
		}
		else
				throw new RecursoNoExiste(id);
		}
	
	
	/**
	 * Actualiza los datos de un usuario segun su id
	 * 
	 * @param id Identificador de un usuario en la base de datos.
	 * 
	 */
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUsuario(@PathParam("id") int id,Usuario user) {
		throw new UnsupportedOperationException();
	}

}
