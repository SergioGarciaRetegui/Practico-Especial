package com.practicoEspecial;

import java.util.List;

import javax.persistence.EntityManager;

public class DonacionDAO  implements DAO<Donacion,Integer>{

	private static DonacionDAO daoDonacion;

	private DonacionDAO() {
	}

	public static DonacionDAO getInstance() {
		if(daoDonacion==null)
			daoDonacion=new DonacionDAO();
		return daoDonacion;
	}

	@Override
	public Donacion findById(Integer id) {
		
		EntityManager entityManager=EMF.createEntityManager();
		Donacion don=entityManager.find(Donacion.class, id);
		entityManager.close();
		return don;
	
	}

	@Override
	public Donacion persist(Donacion don) {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(don);
		entityManager.getTransaction().commit();
		entityManager.close();
		return don;
	}

	@Override
	public List<Donacion> findAll() {
		EntityManager entityManager=EMF.createEntityManager();
		List<Donacion> Donaciones=entityManager.createQuery("SELECT d FROM Donacion d").getResultList();
		entityManager.close();
		return Donaciones;
	}

	@Override
	public boolean delete(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Donacion update(Integer id, Donacion entity) {
		throw new UnsupportedOperationException();
	}


}
