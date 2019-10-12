package com.practicoEspecial;

import java.util.List;

import javax.persistence.EntityManager;

public class PuntoLimpioDAO implements DAO<PuntoLimpio,Integer>{

	private static PuntoLimpioDAO daoPuntoLimpio;

	private PuntoLimpioDAO() {
	}

	public static PuntoLimpioDAO getInstance() {
		if(daoPuntoLimpio==null)
			daoPuntoLimpio=new PuntoLimpioDAO();
		return daoPuntoLimpio;
	}

	@Override
	public PuntoLimpio findById(Integer id) {
		
		EntityManager entityManager=EMF.createEntityManager();
		PuntoLimpio Pl=entityManager.find(PuntoLimpio.class, id);
		entityManager.close();
		return Pl;
	
	}

	@Override
	public PuntoLimpio persist(PuntoLimpio pl) {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(pl);
		entityManager.getTransaction().commit();
		entityManager.close();
		return pl;
	}

	@Override
	public List<PuntoLimpio> findAll() {
		EntityManager entityManager=EMF.createEntityManager();
		List<PuntoLimpio> PuntoLimpios=entityManager.createQuery("SELECT p FROM PuntoLimpio p").getResultList();
		entityManager.close();
		return PuntoLimpios;
	}

	public boolean capacidadAlcanzada(int id) {
		EntityManager entityManager=EMF.createEntityManager();
		PuntoLimpio pl=entityManager.find(PuntoLimpio.class, id);
		entityManager.close();
		return pl.getKgAcumulados()>= pl.getKgTope();
	}
	public int deleteAll() {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		int result=entityManager.createQuery("DELETE FROM PuntoLimpio").executeUpdate();
        entityManager.getTransaction().commit();
		entityManager.close();
		return result;
	}

	@Override
	public boolean delete(Integer id) {
		EntityManager entityManager=EMF.createEntityManager();
		PuntoLimpio pl=entityManager.find(PuntoLimpio.class, id);
		entityManager.getTransaction().begin();
        entityManager.remove(pl);
        entityManager.clear();
        entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}

	@Override
	public PuntoLimpio update(Integer id, PuntoLimpio entity) {
		throw new UnsupportedOperationException();
	}


}
