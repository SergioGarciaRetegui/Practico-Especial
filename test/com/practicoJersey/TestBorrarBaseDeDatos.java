package com.practicoJersey;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.practicoEspecial.Acopio;
import com.practicoEspecial.AcopioDAO;
import com.practicoEspecial.Camion;
import com.practicoEspecial.CamionDAO;
import com.practicoEspecial.Donacion;
import com.practicoEspecial.DonacionDAO;
import com.practicoEspecial.EMF;
import com.practicoEspecial.Ong;
import com.practicoEspecial.OngDAO;
import com.practicoEspecial.PuntoLimpio;
import com.practicoEspecial.PuntoLimpioDAO;
import com.practicoEspecial.Recoleccion;
import com.practicoEspecial.RecoleccionDAO;
import com.practicoEspecial.Residuo;
import com.practicoEspecial.ResiduoDAO;
import com.practicoEspecial.Usuario;
import com.practicoEspecial.UsuarioDAO;

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
