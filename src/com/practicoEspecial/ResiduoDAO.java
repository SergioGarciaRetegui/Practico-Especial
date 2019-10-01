package com.practicoEspecial;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ResiduoDAO implements DAO<Residuo,Integer>{

	private static ResiduoDAO daoRes;

	private ResiduoDAO() {
	}

	public static ResiduoDAO getInstance() {
		if(daoRes==null)
			daoRes=new ResiduoDAO();
		return daoRes;
	}

	@Override
	public Residuo findById(Integer id) {
		
		EntityManager entityManager=EMF.createEntityManager();
		Residuo res=entityManager.find(Residuo.class, id);
		entityManager.close();
		return res;
	
	}

	public boolean esReciclable(String res) {
		boolean result=false;
		EntityManager entityManager=EMF.createEntityManager();
		TypedQuery<Long> allMatchesQuery = entityManager.createQuery("SELECT COUNT(r) FROM Residuo r WHERE r.nombre LIKE :NombRes",Long.class);
    	allMatchesQuery.setParameter("NombRes", res);
    	Long countResult = allMatchesQuery.getSingleResult();
    	if (countResult > 0) {
    		result = true;
    	}		
    	return result;
	}
	
	@Override
	public Residuo persist(Residuo res) {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(res);
		entityManager.getTransaction().commit();
		entityManager.close();
		return res;
	}

	@Override
	public List<Residuo> findAll() {
		EntityManager entityManager=EMF.createEntityManager();
		List<Residuo> residuos=entityManager.createQuery("SELECT r FROM Residuo r").getResultList();
		entityManager.close();
		return residuos;
	}

	@Override
	public boolean delete(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Residuo update(Integer id, Residuo entity) {
		throw new UnsupportedOperationException();
	}


}
