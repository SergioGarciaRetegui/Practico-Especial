package dao;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import generic.DAO;
import generic.EMF;
import model.Donacion;
import model.Residuo;

/**
 * Esta clase gestiona el acceso a la base de datos de los donaciones, 
 * es el intermediario de las consultas relacionadas a los donaciones. 
 * 
 */
public class DonacionDAO  implements DAO<Donacion,Integer>{

	private static DonacionDAO daoDonacion;

	private DonacionDAO() {
	}

	/** devuelve una unica instancia de la clase DonacionDAO, si no existe la crea, si ya esta creada devuelve la instancia
	* 
	*/
	public static DonacionDAO getInstance() {
		if(daoDonacion==null)
			daoDonacion=new DonacionDAO();
		return daoDonacion;
	}

	/**
	 * Devuelve una Donacion persistido en la base de datos segun un id
	 * 
	 * @param id Identificador unico de un Donacion.
	 */
	@Override
	public Donacion findById(Integer id) {
		
		EntityManager entityManager=EMF.createEntityManager();
		Donacion don=entityManager.find(Donacion.class, id);
		entityManager.close();
		return don;
	
	}

	/**
	 * Persiste en la base de datos un objeto Donacion.
	 * 
	 * @param Donacion Es una Instancia de la clase Donacion la cual se quiere persistir en la base
	 * 
	 */
	@Override
	public Donacion persist(Donacion don) {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(don);
		entityManager.getTransaction().commit();
		entityManager.close();
		return don;
	}

	/**
	 * Retorna un listado de todos las donaciones persistidos en la base de datos
	 * 
	 */
	@Override
	public List<Donacion> findAll() {
		EntityManager entityManager=EMF.createEntityManager();
		List<Donacion> Donaciones=entityManager.createQuery("SELECT d FROM Donacion d").getResultList();
		entityManager.close();
		return Donaciones;
	}
	
	/**
	 * Retorna el valor equivalente en dinero de los residuos recibidos por una ONG en concepto de donacion
	 * 
	 * @param id Identificador de una ONG.
	 */
	public Double findAyudaAOng(int id){
		EntityManager entityManager=EMF.createEntityManager();
		List<Donacion> Donaciones=entityManager.createQuery("SELECT d FROM Donacion d INNER JOIN d.ong o WHERE o.id= :idOng ").setParameter("idOng", id).getResultList();
		Iterator itdon = Donaciones.iterator();
		Double result=0.0;
		Donacion donac;
		while(itdon.hasNext()) {
			donac=(Donacion)itdon.next();
			Residuo aux=ResiduoDAO.getInstance().findById(donac.getReciclable().getId());
			result+=aux.getValorKg()*donac.getCant();			
		}				
		entityManager.close();
		return result;
	}
	
	
	/**
	 * Retorna el valor equivalente en dinero de los residuos recibidos por una ONG en concepto de donacion
	 * dentro de un rango de fechas
	 * 
	 * @param id Identificador de una ONG.
	 * @param FechaI Fecha desde inicial de la busqueda formato YYYY/MM/DD.
	 * @param FechaF Fecha hasta donde realizar la busqueda formato YYYY/MM/DD.
	 */
	public Double findAyudaAOngByFecha(int id,Date fechI, Date fechaF){
		EntityManager entityManager=EMF.createEntityManager();
		List<Donacion> Donaciones=entityManager.createQuery("SELECT d FROM Donacion d INNER JOIN d.ong o WHERE o.id= :idOng AND d.fecha BETWEEN :f1 AND :f2").setParameter("idOng", id).setParameter("f1", fechI).setParameter("f2", fechaF).getResultList();
		Iterator itdon = Donaciones.iterator();
		Double result=0.0;
		Donacion donac;
		while(itdon.hasNext()) {
			donac=(Donacion)itdon.next();
			Residuo aux=ResiduoDAO.getInstance().findById(donac.getReciclable().getId());
			result+=aux.getValorKg()*donac.getCant();			
		}				
		entityManager.close();
		return result;
	}

	/**
	 * Borra todos los donaciones persistidos en la base de datos 
	 * 
	 */	
	public int deleteAll() {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		int result=entityManager.createQuery("DELETE FROM Donacion").executeUpdate();
        entityManager.getTransaction().commit();
		entityManager.close();
		return result;
	}

	/**
	 * Borra una Donacion especifico de la base de datos
	 * 
	 * @param id Identificador de una Donacion.
	 */
	@Override
	public boolean delete(Integer id) {
		EntityManager entityManager=EMF.createEntityManager();
		Donacion don=entityManager.find(Donacion.class, id);
		entityManager.getTransaction().begin();
        entityManager.remove(don);
        entityManager.clear();
        entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}

	@Override
	public Donacion update(Integer id, Donacion entity) {
		throw new UnsupportedOperationException();
	}


}
