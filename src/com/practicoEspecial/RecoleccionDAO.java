package com.practicoEspecial;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

public class RecoleccionDAO implements DAO<Recoleccion,Integer>{

	private static RecoleccionDAO daoRecoleccion;

	private RecoleccionDAO() {
	}

	public static RecoleccionDAO getInstance() {
		if(daoRecoleccion==null)
			daoRecoleccion=new RecoleccionDAO();
		return daoRecoleccion;
	}

	@Override
	public Recoleccion findById(Integer id) {
		
		EntityManager entityManager=EMF.createEntityManager();
		Recoleccion rec=entityManager.find(Recoleccion.class, id);
		entityManager.close();
		return rec;
	
	}

	@Override
	public Recoleccion persist(Recoleccion rec) {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(rec);
		entityManager.getTransaction().commit();
		entityManager.close();
		return rec;
	}

	@Override
	public List<Recoleccion> findAll() {
		EntityManager entityManager=EMF.createEntityManager();
		List<Recoleccion> Recolecciones=entityManager.createQuery("SELECT r FROM Recoleccion r").getResultList();
		entityManager.close();
		return Recolecciones;
	}

	public Recoleccion findByIdCamionAndGeopoUser(int idCam,Double lat,Double longi) {
		EntityManager entityManager=EMF.createEntityManager();
		Recoleccion result=null;
		List<Recoleccion> recolecciones=entityManager.createQuery("SELECT r FROM Recoleccion r INNER JOIN r.camionRecolector c WHERE c.id= :idCam ").setParameter("idCam", idCam).getResultList();
		if (recolecciones.size()>0) {
			double dist=-1;
			Iterator itRecol =recolecciones.iterator();
			Recoleccion aux;
			while(itRecol.hasNext()) {
				aux=(Recoleccion)itRecol.next();
				if (dist<0) {
					dist=aux.getPuntoRecoleccion().geoDistancia(lat, longi);
					result=aux;
				}
				else if(dist>aux.getPuntoRecoleccion().geoDistancia(lat, longi)) {
					dist=aux.getPuntoRecoleccion().geoDistancia(lat, longi);
					result=aux;
				}
			}
		}
		else 
		entityManager.close();
		return result;
	}
	
	@Override
	public boolean delete(Integer id) {
		EntityManager entityManager=EMF.createEntityManager();
		Recoleccion recol=entityManager.find(Recoleccion.class, id);
		entityManager.getTransaction().begin();
        entityManager.remove(recol);
        entityManager.clear();
        entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}

	@Override
	public Recoleccion update(Integer id, Recoleccion entity) {
		throw new UnsupportedOperationException();
	}


}
