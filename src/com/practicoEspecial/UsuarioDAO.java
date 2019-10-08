package com.practicoEspecial;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class UsuarioDAO implements DAO<Usuario,Integer>{

	private static UsuarioDAO daoUsuario;

	private UsuarioDAO() {
	}

	public static UsuarioDAO getInstance() {
		if(daoUsuario==null)
			daoUsuario=new UsuarioDAO();
		return daoUsuario;
	}

	@Override
	public Usuario findById(Integer id) {
		
		EntityManager entityManager=EMF.createEntityManager();
		Usuario user=entityManager.find(Usuario.class, id);
		entityManager.close();
		return user;
	
	}

	@Override
	public Usuario persist(Usuario user) {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		entityManager.close();
		return user;
	}

	@Override
	public List<Usuario> findAll() {
		EntityManager entityManager=EMF.createEntityManager();
		List<Usuario> usuarios=entityManager.createQuery("SELECT u FROM Usuario u").getResultList();
		entityManager.close();
		return usuarios;
	}
	
	public List<Recoleccion> recoleccionesPorGeolocalizacion(int id) {
      List<Recoleccion> result = new ArrayList();
      EntityManager entityManager=EMF.createEntityManager();
	  Usuario user= entityManager.find(Usuario.class, id);
	  List<Camion> camiones=CamionDAO.getInstance().findAll();
      Iterator itCamion=camiones.iterator();
      Recoleccion recorr;
      while (itCamion.hasNext()) {
    	  Camion aux=(Camion)itCamion.next();
    	  recorr=RecoleccionDAO.getInstance().findByIdCamionAndGeopoUser(aux.getId(),user.getLatGeoposicion(),user.getLongGeoposicion());
          result.add(recorr);
      }
	  entityManager.close();
      return result;		
      
	}
	public Hashtable<String, Integer> aporteParaOngs(int id) {
		EntityManager entityManager=EMF.createEntityManager();
		Usuario user=entityManager.find(Usuario.class, id);
		entityManager.close();
		List<Residuo> Residuos=AcopioDAO.getInstance().FindTipoDepositadosByID(user.getId());
		Iterator itresiduo=Residuos.iterator();
		Residuo auxres;
		Hashtable<String, Integer> result= new Hashtable<String, Integer>(); 
		int cant=0;
		while(itresiduo.hasNext()) {
			auxres=(Residuo)itresiduo.next();
			cant=AcopioDAO.getInstance().cantResidByIdUserAndIdResiduo(user.getId(), auxres.getId());
            result.put(auxres.getNombre(),cant*(int)auxres.getValorKg());			
		}
		return result;
	}

	@Override
	public boolean delete(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Usuario update(Integer id, Usuario entity) {
		throw new UnsupportedOperationException();
	}


}
