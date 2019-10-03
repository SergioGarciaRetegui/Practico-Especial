package com.practicoEspecial;

import java.util.List;

import javax.persistence.EntityManager;

public class UbicacionDAO implements DAO<Ubicacion,Integer>{

	private static UbicacionDAO ubicacionOng;

	private UbicacionDAO() {
	}
	public static UbicacionDAO getInstance() {
		if(ubicacionOng==null)
			ubicacionOng=new UbicacionDAO();
		return ubicacionOng;
	}
	@Override
	public Ubicacion findById(Integer id) {
		
		EntityManager entityManager=EMF.createEntityManager();
		Ubicacion ong=entityManager.find(Ubicacion.class, id);
		entityManager.close();
		return ong;
	
	}

	@Override
	public Ubicacion persist(Ubicacion Ubic) {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(Ubic);
		entityManager.getTransaction().commit();
		entityManager.close();
		return Ubic;
	}

	@Override
	public List<Ubicacion> findAll() {
		EntityManager entityManager=EMF.createEntityManager();
		List<Ubicacion> Ongs=entityManager.createQuery("SELECT o FROM Ubicacion o").getResultList();
		entityManager.close();
		return Ongs;
	}

	@Override
	public boolean delete(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Ubicacion update(Integer id, Ubicacion entity) {
		throw new UnsupportedOperationException();
	}




}
