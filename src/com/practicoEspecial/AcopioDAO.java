package com.practicoEspecial;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

public class AcopioDAO implements DAO<Acopio,Integer>{

	private static AcopioDAO daoAcopio;

	private AcopioDAO() {
	}

	public static AcopioDAO getInstance() {
		if(daoAcopio==null)
			daoAcopio=new AcopioDAO();
		return daoAcopio;
	}

	@Override
	public Acopio findById(Integer id) {
		
		EntityManager entityManager=EMF.createEntityManager();
		Acopio acopio=entityManager.find(Acopio.class, id);
		entityManager.close();
		return acopio;
	
	}

	public List<Acopio> findByIdUsuario(Integer id) {
/*        List<Acopio> result=new ArrayList<Acopio>();
        Acopio aux;*/
		EntityManager entityManager=EMF.createEntityManager();
		List<Acopio> Acopios=entityManager.createQuery("SELECT a FROM Acopio a INNER JOIN a.user u WHERE u.id= :idUser ").setParameter("idUser", id).getResultList();
/*		for(int x=0;x<Acopios.size();x++) {
			aux=Acopios.get(x);
			if (aux.user.getId()==id) {
				result.add(aux);
			}
		}*/
		entityManager.close();
		return Acopios;
	}

	public List<Acopio> findByIdUsuarioAndfechas(Integer id,Date FechaI, Date FechaF){
		EntityManager entityManager=EMF.createEntityManager();
		List<Acopio> Acopios=entityManager.createQuery("SELECT a FROM Acopio a INNER JOIN a.user u WHERE u.id= :idUser AND a.fechaAcopio BETWEEN :f1 AND :f2").setParameter("idUser", id).setParameter("f1",FechaI).setParameter("f2",FechaF).getResultList();
		entityManager.close();
		return Acopios;
	}	

	public List<Residuo> findByIdPuntoLimpioAndfechas(Integer id,Date FechaI, Date FechaF){
		EntityManager entityManager=EMF.createEntityManager();
		List<Residuo> resid=entityManager.createQuery("SELECT a.reciclable FROM Acopio a INNER JOIN a.puntlimpio p WHERE p.id= :idPL AND a.fechaAcopio BETWEEN :f1 AND :f2").setParameter("idPL", id).setParameter("f1",FechaI).setParameter("f2",FechaF).getResultList();
		entityManager.close();
		return resid;
	}	

	@Override
	public Acopio persist(Acopio acopio) {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(acopio);
		entityManager.getTransaction().commit();
		entityManager.close();
		return acopio;
	}

	@Override
	public List<Acopio> findAll() {
		EntityManager entityManager=EMF.createEntityManager();
		List<Acopio> Acopios=entityManager.createQuery("SELECT a FROM Acopio a").getResultList();
		entityManager.close();
		return Acopios;
	}

	@Override
	public boolean delete(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Acopio update(Integer id, Acopio entity) {
		throw new UnsupportedOperationException();
	}


}
