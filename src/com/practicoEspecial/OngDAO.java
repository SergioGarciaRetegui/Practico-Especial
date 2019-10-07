package com.practicoEspecial;

import java.util.List;

import javax.persistence.EntityManager;

public class OngDAO  implements DAO<Ong,Integer>{

	private static OngDAO daoOng;

	private OngDAO() {
	}

	public static OngDAO getInstance() {
		if(daoOng==null)
			daoOng=new OngDAO();
		return daoOng;
	}

	@Override
	public Ong findById(Integer id) {
		
		EntityManager entityManager=EMF.createEntityManager();
		Ong ong=entityManager.find(Ong.class, id);
		entityManager.close();
		return ong;
	
	}

	@Override
	public Ong persist(Ong ong) {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(ong);
		entityManager.getTransaction().commit();
		entityManager.close();
		return ong;
	}

	@Override
	public List<Ong> findAll() {
		EntityManager entityManager=EMF.createEntityManager();
		List<Ong> Ongs=entityManager.createQuery("SELECT o FROM Ong o").getResultList();
		entityManager.close();
		return Ongs;
	}

	@Override
	public boolean delete(Integer id) {
		EntityManager entityManager=EMF.createEntityManager();
		Ong ong=entityManager.find(Ong.class, id);
		entityManager.getTransaction().begin();
        entityManager.remove(ong);
        entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}

	@Override
	public Ong update(Integer id, Ong entity) {
		throw new UnsupportedOperationException();
	}


}
