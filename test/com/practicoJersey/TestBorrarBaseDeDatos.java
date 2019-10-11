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
          List<Usuario> us=UsuarioDAO.getInstance().findAll();
	      Iterator itUs=us.iterator();
	      while (itUs.hasNext()) {
	    	  Usuario auxUs=(Usuario)itUs.next();
	    	  UsuarioDAO.getInstance().delete(auxUs.getId());
	      }

	      List<PuntoLimpio> pl=PuntoLimpioDAO.getInstance().findAll();
	      Iterator itPl=pl.iterator();
	      while (itPl.hasNext()) {
	    	  PuntoLimpio auxpl=(PuntoLimpio)itPl.next();
	    	  PuntoLimpioDAO.getInstance().delete(auxpl.getId());
	      }
	      List<Ong> ongs=OngDAO.getInstance().findAll();
	      Iterator itong=ongs.iterator();
	      while (itong.hasNext()) {
	    	  Ong ong=(Ong)itong.next();
	    	  OngDAO.getInstance().delete(ong.getId());
	      }
 
	      List<Residuo> Resids=ResiduoDAO.getInstance().findAll();
	      Iterator itres=Resids.iterator();
	      while (itres.hasNext()) {
	    	  Residuo res=(Residuo)itres.next();
	    	  ResiduoDAO.getInstance().delete(res.getId());
	      }

	      List<Camion> Camions=CamionDAO.getInstance().findAll();
	      Iterator itCamion=Camions.iterator();
	      while (itCamion.hasNext()) {
	    	  Camion aux=(Camion)itCamion.next();
	    	  CamionDAO.getInstance().delete(aux.getId());
	      }

	      List<Recoleccion> recols=RecoleccionDAO.getInstance().findAll();
	      Iterator itrecol=recols.iterator();
	      while (itrecol.hasNext()) {
	    	  Recoleccion aux=(Recoleccion)itrecol.next();
	    	  RecoleccionDAO.getInstance().delete(aux.getId());
	      }

	      List<Acopio> acopios=AcopioDAO.getInstance().findAll();
	      Iterator itacopio=acopios.iterator();
	      while (itacopio.hasNext()) {
	    	  Acopio aux=(Acopio)itacopio.next();
	    	  AcopioDAO.getInstance().delete(aux.getId());
	      }

	      List<Donacion> donaciones=DonacionDAO.getInstance().findAll();
	      Iterator itdonacion=donaciones.iterator();
	      while (itdonacion.hasNext()) {
	    	  Donacion aux=(Donacion)itdonacion.next();
	    	  DonacionDAO.getInstance().delete(aux.getId());
	      }

	}
	@Test
	public void testlistados() {
		System.out.println(UsuarioDAO.getInstance().findAll());
	}

}
