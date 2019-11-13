package generic;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Excepcion que indica que un recurso que se intenta crear ya existe en la base de datos  
 */
public class RecursoDuplicado extends WebApplicationException {
    public RecursoDuplicado(int id) {
        super(Response.status(Response.Status.CONFLICT)
            .entity("El recurso con ID "+id+" ya existe").type(MediaType.TEXT_PLAIN).build());
    }
} 
