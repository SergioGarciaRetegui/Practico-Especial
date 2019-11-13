package dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import generic.DAO;
import generic.EMF;
import model.Recoleccion;

/**
 * Esta clase gestiona el acceso a la base de datos de los Recoleccion, 
 * es el intermediario de las consultas relacionadas a los Recolecciones.
 * 
 */

public class RecoleccionDAO implements DAO<Recoleccion,Integer>{

	private static RecoleccionDAO daoRecoleccion;

	private RecoleccionDAO() {
	}

	/** 
	* Devuelve una unica instancia de la clase RecoleccionDAO, si no existe la crea, si ya esta creada devuelve la instancia
	* 
	*/
	public static RecoleccionDAO getInstance() {
		if(daoRecoleccion==null)
			daoRecoleccion=new RecoleccionDAO();
		return daoRecoleccion;
	}

	/**
	 * Devuelve una Recoleccion persistida en la base de datos segun un id
	 * 
	 * @param id Identificador unico de una Recoleccion.
	 */
	@Override
	public Recoleccion findById(Integer id) {
		
		EntityManager entityManager=EMF.createEntityManager();
		Recoleccion rec=entityManager.find(Recoleccion.class, id);
		entityManager.close();
		return rec;
	
	}

	/**
	 * Persiste en la base de datos un objeto Recoleccion.
	 * 
	 * @param rec Es una Instancia de la clase Recoleccion la cual se quiere persistir en la base
	 * 
	 */
	@Override
	public Recoleccion persist(Recoleccion rec) {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(rec);
		entityManager.getTransaction().commit();
		entityManager.close();
		return rec;
	}

	/**
	 * Retorna un listado de todas las Recolecciones persistidas en la base de datos
	 * 
	 */
	@Override
	public List<Recoleccion> findAll() {
		EntityManager entityManager=EMF.createEntityManager();
		List<Recoleccion> Recolecciones=entityManager.createQuery("SELECT r FROM Recoleccion r").getResultList();
		entityManager.close();
		return Recolecciones;
	}

	/**
	 * Retorna el punto de recoleccion mas cercana a uan geoposicion dada y un camion. 
	 * 
	 * @param idCam Identifica un Camion.
	 * @param lat  Latitud de una geoposicion
	 * @param longi Longitud de una geoposicion.
	 * 
	 */
	public Recoleccion findByIdCamionAndGeopoUser(int idCam,Double lat,Double longi) {
		EntityManager entityManager=EMF.createEntityManager();
		Recoleccion result=null;
		List<Recoleccion> recolecciones=entityManager.createQuery("SELECT r FROM Recoleccion r INNER JOIN r.camionRecolector c WHERE c.id= :idCam ").setParameter("idCam", idCam).getResultList();
		if (recolecciones.size()>0) {
			double dist=-1;
			Iterator itRecol =recolecciones.iterator();
			Recoleccion aux;
			while(itRecol.hasNext()) {
				aux=(Recoleccion)itRecol.next();
				if (dist<0) {
					dist=aux.getPuntoRecoleccion().geoDistancia(lat, longi);
					result=aux;
				}
				else if(dist>aux.getPuntoRecoleccion().geoDistancia(lat, longi)) {
					dist=aux.getPuntoRecoleccion().geoDistancia(lat, longi);
					result=aux;
				}
			}
		}
		else 
		entityManager.close();
		return result;
	}

	
	/**
	 * Borra todos las Recolecciones persistidos en la base de datos 
	 * 
	 */	
	public int deleteAll() {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		int result=entityManager.createQuery("DELETE FROM Recoleccion").executeUpdate();
        entityManager.getTransaction().commit();
		entityManager.close();
		return result;
	}
	
	/**
	 * Borra una Recoleccion especifica de la base de datos
	 * 
	 * @param id Identificador de una Recoleccion.
	 */
	@Override
	public boolean delete(Integer id) {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		int result=entityManager.createQuery("DELETE FROM Recoleccion r WHERE r.id= :id").setParameter("id", id).executeUpdate();
		entityManager.getTransaction().commit();
		entityManager.close();
		if (result ==0)
   		    return false;
		else 
			return true;
	}

	/**
	 * Actualiza una Recoleccion en la base de datos
	 * 
	 * @param id identificador de una Recoleccion.
	 * @param entity Instancia de la clase Recoleccion la cual contiene los valores a actualizar 
	 */
	@Override
	public Recoleccion update(Integer id, Recoleccion entity) {
		throw new UnsupportedOperationException();
	}


}
