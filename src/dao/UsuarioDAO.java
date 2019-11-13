package dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import generic.DAO;
import generic.EMF;
import model.Camion;
import model.Recoleccion;
import model.Residuo;
import model.Usuario;

/**
 * Esta clase gestiona el acceso a la base de datos de los Usuarios, 
 * es el intermediario de las consultas relacionadas a los Usuarios.
 * 
 * 
 */
public class UsuarioDAO implements DAO<Usuario,Integer>{

	private static UsuarioDAO daoUsuario;

	private UsuarioDAO() {
	}

	/** 
	* Devuelve una unica instancia de la clase UsuarioDAO, si no existe la crea, si ya esta creada devuelve la instancia
	* 
	*/
	public static UsuarioDAO getInstance() {
		if(daoUsuario==null)
			daoUsuario=new UsuarioDAO();
		return daoUsuario;
	}

	/**
	 * Devuelve un usuario persistido en la base de datos segun un id
	 * 
	 * @param id Identificador unico de un Usuario.
	 */
	@Override
	public Usuario findById(Integer id) {
		
		EntityManager entityManager=EMF.createEntityManager();
		Usuario user=entityManager.find(Usuario.class, id);
		entityManager.close();
		return user;
	
	}

	/**
	 * Persiste en la base de datos un objeto Usuario.
	 * 
	 * @param user Es una Instancia de la clase Usuario la cual se quiere persistir en la base
	 * 
	 */
	@Override
	public Usuario persist(Usuario user) {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		entityManager.close();
		return user;
	}

	/**
	 * Retorna un listado de todos los Usuarios persistidos en la base de datos
	 * 
	 */
	@Override
	public List<Usuario> findAll() {
		EntityManager entityManager=EMF.createEntityManager();
		List<Usuario> usuarios=entityManager.createQuery("SELECT u FROM Usuario u").getResultList();
		entityManager.close();
		return usuarios;
	}
	
	/**
	 * Retorna un listado de todos los puntos de recolecion mas cercanos a un Usuario segun su geoposicion
	 * 
	 * @param id Identificador de Usuario.
	 */
	public List<Recoleccion> recoleccionesPorGeolocalizacion(int id) {
      List<Recoleccion> result = new ArrayList();
      EntityManager entityManager=EMF.createEntityManager();
	  Usuario user= entityManager.find(Usuario.class, id);
	  List<Camion> camiones=CamionDAO.getInstance().findAll();
      Iterator itCamion=camiones.iterator();
      Recoleccion recorr;
      while (itCamion.hasNext()) {
    	  Camion aux=(Camion)itCamion.next();
    	  recorr=RecoleccionDAO.getInstance().findByIdCamionAndGeopoUser(aux.getId(),user.getLatGeoposicion(),user.getLongGeoposicion());
          result.add(recorr);
      }
	  entityManager.close();
      return result;		
      
	}
	
	/**
	 * Retorna para un usuario los residuos depositados y el equivalente en $ de sus deposiciones.
	 * 
	 * @param id Identificador de un Usuario
	 * 
	 * @return Hastable<String,Integer> retorna una tabla con los pares residuos y dinero equivalente.
	 */
	public Hashtable<String, Integer> aporteParaOngs(int id) {
		EntityManager entityManager=EMF.createEntityManager();
		Usuario user=entityManager.find(Usuario.class, id);
		entityManager.close();
		List<Residuo> Residuos=AcopioDAO.getInstance().FindTipoDepositadosByID(user.getId());
		Iterator itresiduo=Residuos.iterator();
		Residuo auxres;
		Hashtable<String, Integer> result= new Hashtable<String, Integer>(); 
		int cant=0;
		while(itresiduo.hasNext()) {
			auxres=(Residuo)itresiduo.next();
			cant=AcopioDAO.getInstance().cantResidByIdUserAndIdResiduo(user.getId(), auxres.getId());
            result.put(auxres.getNombre(),cant*(int)auxres.getValorKg());			
		}
		return result;
	}
	
	
	/**
	 * Borra todos los Usuarios persistidos en la base de datos 
	 * 
	 */	
	public int deleteAll() {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		int result=entityManager.createQuery("DELETE FROM Usuario").executeUpdate();
        entityManager.getTransaction().commit();
		entityManager.close();
		return result;
	}

	/**
	 * Borra un Usuario especifico de la base de datos
	 * 
	 * @param id Identificador de un Usuario.
	 */
	@Override
	public boolean delete(Integer id) {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		int result=entityManager.createQuery("DELETE FROM Usuario u WHERE u.id= :id").setParameter("id", id).executeUpdate();
		entityManager.getTransaction().commit();
		entityManager.close();
		if (result ==0)
   		    return false;
		else 
			return true;
	}

	
	/**
	 * Actualiza un Usuario en la base de datos
	 * 
	 * @param id identificador de un Usuario.
	 * @param entity Instancia de la clase Usuario la cual contiene los valores a actualizar 
	 */
	@Override
	public Usuario update(Integer id, Usuario entity) {
		throw new UnsupportedOperationException();
	}


}
