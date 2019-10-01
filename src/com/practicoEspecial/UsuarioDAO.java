package com.practicoEspecial;

import java.util.List;

import javax.persistence.EntityManager;

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

	@Override
	public boolean delete(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Usuario update(Integer id, Usuario entity) {
		throw new UnsupportedOperationException();
	}


}
