package dao;

import java.util.List;

import javax.persistence.EntityManager;

import generic.DAO;
import generic.EMF;
import model.Ong;

/**
 * Esta clase gestiona el acceso a la base de datos de las ONG, 
 * es el intermediario de las consultas relacionadas a las ONG. 
 * 
 */
public class OngDAO  implements DAO<Ong,Integer>{

	private static OngDAO daoOng;

	private OngDAO() {
	}

	/** devuelve una unica instancia de la clase OngDAO, si no existe la crea, si ya esta creada devuelve la instancia
	* 
	*/
	public static OngDAO getInstance() {
		if(daoOng==null)
			daoOng=new OngDAO();
		return daoOng;
	}

	/**
	 * Devuelve un Ong persistido en la base de datos segun un id
	 * 
	 * @param id Identificador unico de un Ong.
	 */
	@Override
	public Ong findById(Integer id) {
		
		EntityManager entityManager=EMF.createEntityManager();
		Ong ong=entityManager.find(Ong.class, id);
		entityManager.close();
		return ong;
	
	}

	/**
	 * Persiste en la base de datos un objeto Ong.
	 * 
	 * @param ong Es una Instancia de la clase Ong la cual se quiere persistir en la base
	 * 
	 */
	@Override
	public Ong persist(Ong ong) {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(ong);
		entityManager.getTransaction().commit();
		entityManager.close();
		return ong;
	}

	/**
	 * Retorna un listado de todos las ongs persistidos en la base de datos
	 * 
	 */
	@Override
	public List<Ong> findAll() {
		EntityManager entityManager=EMF.createEntityManager();
		List<Ong> Ongs=entityManager.createQuery("SELECT o FROM Ong o").getResultList();
		entityManager.close();
		return Ongs;
	}
	
	/**
	 * Borra todas las Ongs persistidos en la base de datos 
	 * 
	 */	
	public int deleteAll() {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		int result=entityManager.createQuery("DELETE FROM Ong").executeUpdate();
        entityManager.getTransaction().commit();
		entityManager.close();
		return result;
	}

	/**
	 * Borra una Ong especifico de la base de datos
	 * 
	 * @param id Identificador de una Ong.
	 */
	@Override
	public boolean delete(Integer id) {
		EntityManager entityManager=EMF.createEntityManager();
		Ong ong=entityManager.find(Ong.class, id);
		entityManager.getTransaction().begin();
        entityManager.remove(ong);
        entityManager.clear();
        entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}
	
	/**
	 * Actualiza un camion en la base de datos
	 * 
	 * @param id identificador de un Ong.
	 * @param entity Instancia de la clase ong la cual contiene los valores a actualizar 
	 */
	@Override
	public Ong update(Integer id, Ong entity) {
		throw new UnsupportedOperationException();
	}


}
