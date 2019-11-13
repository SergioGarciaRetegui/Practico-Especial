package dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import generic.DAO;
import generic.EMF;
import model.Camion;

/**
 * Esta clase gestiona el acceso a la base de datos de los camiones, 
 * es el intermediario de las consultas relacionadas a los camiones. 
 * 
 */
public class CamionDAO implements DAO<Camion,Integer>{

	private static CamionDAO daoCamion;

	private CamionDAO() {
	}

	/** 
	* Devuelve una unica instancia de la clase CamionDAO, si no existe la crea, si ya esta creada devuelve la instancia
	* 
	*/
	public static CamionDAO getInstance() {
		if(daoCamion==null)
			daoCamion=new CamionDAO();
		return daoCamion;
	}
	
	/**
	 * Devuelve un Camion persistido en la base de datos segun un id
	 * 
	 * @param id Identificador unico de un Camion.
	 */
	@Override
	public Camion findById(Integer id) {
		
		EntityManager entityManager=EMF.createEntityManager();
		Camion camion=entityManager.find(Camion.class, id);
		entityManager.close();
		return camion;
	
	}

	/**
	 * Persiste en la base de datos un objeto Camion.
	 * 
	 * @param camion Es una Instancia de la clase Camion la cual se quiere persistir en la base
	 * 
	 */
	@Override
	public Camion persist(Camion camion) {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(camion);
		entityManager.getTransaction().commit();
		entityManager.close();
		return camion;
	}

	/**
	 * Retorna un listado de todos los camiones persistidos en la base de datos
	 * 
	 */
	@Override
	public List<Camion> findAll() {
		EntityManager entityManager=EMF.createEntityManager();		
		List<Camion> Camions=entityManager.createQuery("SELECT c FROM Camion c").getResultList();
		entityManager.close();
		return Camions;
	}
	
	/**
	 * Borra todos los camiones persistidos en la base de datos 
	 * 
	 */	
	public int deleteAll() {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		int result=entityManager.createQuery("DELETE FROM Camion").executeUpdate();
        entityManager.getTransaction().commit();
		entityManager.close();
		return result;
	}

	/**
	 * Borra un Camion especifico de la base de datos
	 * 
	 * @param id Identificador de un Camion.
	 */
	@Override
	public boolean delete(Integer id) {
		EntityManager entityManager=EMF.createEntityManager();
		Camion camion=entityManager.find(Camion.class, id);
		entityManager.getTransaction().begin();
        entityManager.remove(camion);
        entityManager.clear();
        entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}

	/**
	 * Actualiza un camion en la base de datos
	 * 
	 * @param id identificador de un Camion.
	 * @param entity Instancia de la clase Camion la cual contiene los valores a actualizar 
	 */
	@Override
	public Camion update(Integer id, Camion entity) {
		throw new UnsupportedOperationException();
	}


}
