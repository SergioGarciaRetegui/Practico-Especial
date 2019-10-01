package com.practicoJersey;

import static org.junit.Assert.*;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.practicoEspecial.AcopioDAO;
import com.practicoEspecial.EMF;

public class testAcopio {

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
	public void testConsultaUsuarioAndFechas() {
    System.out.println(AcopioDAO.getInstance().findByIdUsuarioAndfechas(2, Date.valueOf("2019-01-01"), Date.valueOf("2019-12-01")));
	}
	@Test
	public void testConsultaPuntoLimpioAndFechas() {
    System.out.println(AcopioDAO.getInstance().findByIdPuntoLimpioAndfechas(5, Date.valueOf("2019-01-01"), Date.valueOf("2019-12-01")));
	}

}
