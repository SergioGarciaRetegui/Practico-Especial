package com.practicoJersey;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.AcopioDAO;
import dao.CamionDAO;
import dao.DonacionDAO;
import dao.OngDAO;
import dao.PuntoLimpioDAO;
import dao.RecoleccionDAO;
import dao.ResiduoDAO;
import dao.UsuarioDAO;
import generic.EMF;

public class TestListadoBaseDeDatos {


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		EMF emf = new EMF();
		emf.contextInitialized(null);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		EMF emf = new EMF();
		emf.contextDestroyed(null);		
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testlistados() {
		System.out.println(UsuarioDAO.getInstance().findAll());
		System.out.println(OngDAO.getInstance().findAll());
		System.out.println(ResiduoDAO.getInstance().findAll());
		System.out.println(CamionDAO.getInstance().findAll());
		System.out.println(PuntoLimpioDAO.getInstance().findAll());
		System.out.println(RecoleccionDAO.getInstance().findAll());
		System.out.println(DonacionDAO.getInstance().findAll());
		System.out.println(AcopioDAO.getInstance().findAll());
	}

}
