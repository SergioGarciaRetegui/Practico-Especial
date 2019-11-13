package com.practicoJersey;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
import model.Ubicacion;
import model.Usuario;

public class testConsultasVarias {

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
	public void testConsultaPuntoLimpioAndFechas() {
    PuntoLimpio PL=PuntoLimpioDAO.getInstance().findById(7);
    if(PL!=null) {
    	System.out.println("Residuos reciclados en Punto limpio por rango de fecha");
    	System.out.println("Punto limpio: "+PL.getNombre());
    	System.out.println("Desde: "+Date.valueOf("2019-01-31"));
    	System.out.println("Hasta: "+Date.valueOf("2019-11-01"));
    	List<Residuo> residuos=AcopioDAO.getInstance().findByIdPuntoLimpioAndfechas(7, Date.valueOf("2019-01-01"), Date.valueOf("2019-12-01"));
    	if(residuos.size()>0) {
    		Iterator it=residuos.iterator();
    		Residuo aux;
    		while(it.hasNext()) {
    			aux=(Residuo)it.next();
    			System.out.println("Residuo: "+aux.getNombre());
    			System.out.println("-------------------------------------------------------");
    		}
    		System.out.println("-------------------------------------------------------");
    	}
    	else {
    		System.out.println("El punto limpio no tiene residuos Reciclados");	
    	}
    System.out.println("-------------------------------------------------------");
    System.out.println("*******************************************************");
    System.out.println("-------------------------------------------------------");
    }    
	}
	
	@Test
	public void testEsReciclable() {
		 System.out.println("Test Consulta si residuo es reciclable");
		if (ResiduoDAO.getInstance().esReciclable("Vidrio")) {
		System.out.println("El residuo es reciclable");	
		}
		else {
			System.out.println("El residuo no es reciclable");
		}
	System.out.println("-------------------------------------------------------");
	System.out.println("*******************************************************");
	System.out.println("-------------------------------------------------------");

	}
//-----------------------------------------------------------------------
	@Test
	public void testVolumenAlcanzado() {
		 System.out.println("Test Volumen alcanzado en Punto limpio");
		PuntoLimpio pl=PuntoLimpioDAO.getInstance().findById(7);
		if (pl!=null) {
		if (PuntoLimpioDAO.getInstance().capacidadAlcanzada(7)) {
			System.out.println("El Punto limpio "+pl.getNombre()+" llego al tope de su capacidad");
		}
		else {
			System.out.println("El Punto limpio "+pl.getNombre()+" aun no llego al tope de su capacidad");
		}
		}
		else {
			System.out.println("El Punto limpio no existe");
		}
		 System.out.println("-------------------------------------------------------");
		 System.out.println("*******************************************************");
		 System.out.println("-------------------------------------------------------");

	}
//-----------------------------------------------------------------------

	@Test
	public void testAyudaONG() {
	 System.out.println("Test Aportes a ONGs");
	 System.out.println("la Ong "+OngDAO.getInstance().findById(11).getNombre()+" obtubo $"+DonacionDAO.getInstance().findAyudaAOng(11)+" en donaciones");
	 System.out.println("-------------------------------------------------------");
	 System.out.println("*******************************************************");
	 System.out.println("-------------------------------------------------------");
	}
	
	@Test
	public void testAyudaONGByFecha() {
	Date fechaI=Date.valueOf("2019-09-30");
	Date fechaF=Date.valueOf("2019-10-01");
	System.out.println("Test Aportes a ONGs entre dos fechas");
	System.out.println("la Ong entre 2019-09-30 y el 2019-10-01 "+OngDAO.getInstance().findById(11).getNombre()+" obtubo $"+DonacionDAO.getInstance().findAyudaAOngByFecha(11, fechaI, fechaF)+" en donaciones");
	System.out.println("-------------------------------------------------------");
	System.out.println("*******************************************************");
	System.out.println("-------------------------------------------------------");
	}
//Listado total de residuos procesados
	@Test
	public void TotalResiduosProcesados(){
		System.out.println("Test Total de residuos procesados por tipo y cantidad");
		System.out.println(AcopioDAO.getInstance().TotalResiduosProcesados());
		System.out.println("-------------------------------------------------------");
		System.out.println("*******************************************************");
		System.out.println("-------------------------------------------------------");
	}
	
//Listado total de residuos por rango de fecha
	@Test
	public void TotalResiduosProcesadosPorFecha(){
		Date fechaI=Date.valueOf("2019-09-01");
		Date fechaF=Date.valueOf("2019-10-01");
		System.out.println("Test Total de residuos procesados por tipo y cantidad entre fechas");
		System.out.println(AcopioDAO.getInstance().TotalResiduosProcesadosByFecha(fechaI, fechaF));
		System.out.println("-------------------------------------------------------");
		System.out.println("*******************************************************");
		System.out.println("-------------------------------------------------------");

	}
	
	/**
	 *Rankig de acopio por pl. 
	 */

	@Test
	public void RankingPuntoLimpio(){
		System.out.println("Test Rankig de Acopios en PuntoLimpio");
		System.out.println(AcopioDAO.getInstance().RankingPL());
		System.out.println("-------------------------------------------------------");
		System.out.println("*******************************************************");
		System.out.println("-------------------------------------------------------");
	}
	
//-----------------------------------------------------------------------
}
