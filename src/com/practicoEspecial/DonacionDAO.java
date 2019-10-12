package com.practicoEspecial;

import java.sql.Date;
import java.util.Iterator;
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

	public int deleteAll() {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		int result=entityManager.createQuery("DELETE FROM Donacion").executeUpdate();
        entityManager.getTransaction().commit();
		entityManager.close();
		return result;
	}
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
