package com.practicoJersey;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

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
import model.Acopio;
import model.Camion;
import model.Donacion;
import model.Ong;
import model.PuntoLimpio;
import model.Recoleccion;
import model.Residuo;
import model.Usuario;

public class TestBorrarBaseDeDatos {

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
	public void BorrarDB() {
		System.out.println("Usuarios borrados: "+UsuarioDAO.getInstance().deleteAll());
		System.out.println("Punto limpio borrados: "+PuntoLimpioDAO.getInstance().deleteAll());
		System.out.println("Camiones borrados: "+CamionDAO.getInstance().deleteAll());
		System.out.println("Residuos borrados: "+ResiduoDAO.getInstance().deleteAll());
		System.out.println("Ong borradas: "+OngDAO.getInstance().deleteAll());
		System.out.println("Acopios borrados: "+AcopioDAO.getInstance().deleteAll());
		System.out.println("Recolecciones borradas: "+RecoleccionDAO.getInstance().deleteAll());
		System.out.println("Donaciones borradas: "+DonacionDAO.getInstance().deleteAll());
	}	

}
