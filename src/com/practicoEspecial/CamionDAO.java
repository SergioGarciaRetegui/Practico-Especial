package com.practicoEspecial;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

public class CamionDAO implements DAO<Camion,Integer>{

	private static CamionDAO daoCamion;

	private CamionDAO() {
	}

	public static CamionDAO getInstance() {
		if(daoCamion==null)
			daoCamion=new CamionDAO();
		return daoCamion;
	}

	@Override
	public Camion findById(Integer id) {
		
		EntityManager entityManager=EMF.createEntityManager();
		Camion camion=entityManager.find(Camion.class, id);
		entityManager.close();
		return camion;
	
	}

	@Override
	public Camion persist(Camion camion) {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(camion);
		entityManager.getTransaction().commit();
		entityManager.close();
		return camion;
	}

	@Override
	public List<Camion> findAll() {
		EntityManager entityManager=EMF.createEntityManager();		
		List<Camion> Camions=entityManager.createQuery("SELECT c FROM Camion c").getResultList();
		entityManager.close();
		return Camions;
	}
	public int deleteAll() {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		int result=entityManager.createQuery("DELETE FROM Camion").executeUpdate();
        entityManager.getTransaction().commit();
		entityManager.close();
		return result;
	}

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

	@Override
	public Camion update(Integer id, Camion entity) {
		throw new UnsupportedOperationException();
	}


}
