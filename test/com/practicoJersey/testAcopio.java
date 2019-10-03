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
import com.practicoEspecial.Camion;
import com.practicoEspecial.CamionDAO;
import com.practicoEspecial.EMF;
import com.practicoEspecial.Ong;
import com.practicoEspecial.OngDAO;
import com.practicoEspecial.PuntoLimpio;
import com.practicoEspecial.PuntoLimpioDAO;
import com.practicoEspecial.Residuo;
import com.practicoEspecial.ResiduoDAO;
import com.practicoEspecial.Ubicacion;
import com.practicoEspecial.UbicacionDAO;
import com.practicoEspecial.Usuario;
import com.practicoEspecial.UsuarioDAO;

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
	public void testInicializarBD() {
    crearUsuarios();
    crearPuntosLimpios();
    crearOng();
    crearResiduos();
    crearCamiones();
    crearDonaciones();
    crearRecolecciones();
	}

/*	@Test
	public void testConsultaUsuarioAndFechas() {
    System.out.println(AcopioDAO.getInstance().findByIdUsuarioAndfechas(2, Date.valueOf("2019-01-01"), Date.valueOf("2019-12-01")));
	}
	@Test
	public void testConsultaPuntoLimpioAndFechas() {
    System.out.println(AcopioDAO.getInstance().findByIdPuntoLimpioAndfechas(5, Date.valueOf("2019-01-01"), Date.valueOf("2019-12-01")));
	}*/
	
	public void crearUsuarios() {
	  Usuario user1=new Usuario();
	  user1.setApellido("Perez");
	  user1.setNombre("Jose");
	  user1.setDni(111111);
	  user1.setEmail("user1@email.com");
	  user1.setCalle("Yrigoyen");
	  user1.setNumero(1253);
	  Ubicacion Ub1=new Ubicacion();
	  Ub1.setLatitud(-37.318876);
	  Ub1.setLongitud(-59.142485);
	  Ubicacion Ub=UbicacionDAO.getInstance().persist(Ub1);
	  user1.setGeoposicion(Ub1);
	  Usuario result=UsuarioDAO.getInstance().persist(user1);
	  System.out.println(result);
  
	  Usuario user2=new Usuario();
	  user2.setApellido("Gonzales");
	  user2.setNombre("Pedro");
	  user2.setDni(222222);
	  user2.setEmail("user2@email.com");
	  user2.setCalle("Pinto");
	  user2.setNumero(646);
	  Ubicacion Ub2=new Ubicacion();
	  Ub2.setLatitud(-37.327826);
	  Ub2.setLongitud(-59.136778);
	  Ub=UbicacionDAO.getInstance().persist(Ub2);
	  user2.setGeoposicion(Ub2);
	  result= UsuarioDAO.getInstance().persist(user2);
	  System.out.println(result);

	  Usuario user3=new Usuario();
	  user3.setApellido("Lopez");
	  user3.setNombre("Miguel");
	  user3.setDni(333333);
	  user3.setEmail("user3@email.com");
	  user3.setCalle("Figueroa");
	  user3.setNumero(853);
	  Ubicacion Ub3=new Ubicacion();
	  Ub3.setLatitud(-37.308679);
	  Ub3.setLongitud(-59.150263);
	  Ub=UbicacionDAO.getInstance().persist(Ub3);
	  user3.setGeoposicion(Ub3);
	  result=UsuarioDAO.getInstance().persist(user3);
	  System.out.println(result);

	  Usuario user4=new Usuario();
	  user4.setApellido("Garcia");
	  user4.setNombre("Eduardo");
	  user4.setDni(444444);
	  user4.setEmail("user4@email.com");
	  user4.setCalle("Colombia");
	  user4.setNumero(540);
	  Ubicacion Ub4=new Ubicacion();
	  Ub4.setLatitud(-37.319004);
	  Ub4.setLongitud(-59.114569);
	  Ub=UbicacionDAO.getInstance().persist(Ub4);
	  user4.setGeoposicion(Ub4);
	  result=UsuarioDAO.getInstance().persist(user4);
	  System.out.println(result);

	  Usuario user5=new Usuario();
	  user5.setApellido("Torres");
	  user5.setNombre("Luciana");
	  user5.setDni(555555);
	  user5.setEmail("user5@email.com");
	  user5.setCalle("Roca");
	  user5.setNumero(602);
	  Ubicacion Ub5=new Ubicacion();
	  Ub5.setLatitud(-37.322178);
	  Ub5.setLongitud(-59.126541);
	  user5.setGeoposicion(Ub5);
	  Ub=UbicacionDAO.getInstance().persist(Ub5);
	  result=UsuarioDAO.getInstance().persist(user5);
	  System.out.println(result);

	  Usuario user6=new Usuario();
	  user6.setApellido("Nartinez");
	  user6.setNombre("Josefina");
	  user6.setDni(666666);
	  user6.setEmail("user6@email.com");
	  user6.setCalle("Montiel");
	  user6.setNumero(1223);
	  Ubicacion Ub6=new Ubicacion();
	  Ub6.setLatitud(-37.313714);
	  Ub6.setLongitud(-59.127701);
	  user6.setGeoposicion(Ub6);
	  Ub=UbicacionDAO.getInstance().persist(Ub6);
	  result=UsuarioDAO.getInstance().persist(user6);
	  System.out.println(result);
	}
	public void crearPuntosLimpios() {
	  PuntoLimpio Pl1 = new PuntoLimpio();
	  Pl1.setNombre("Norte");
	  Pl1.setKgTope(1000);
	  Pl1.setKgAcumulados(0);
	  Pl1.setCalle("Quintana");
	  Pl1.setNumero(950);
	  Ubicacion Ub1=new Ubicacion();
	  Ub1.setLatitud(-37.303301);
	  Ub1.setLongitud(-59.147978);
	  Ubicacion Ub=UbicacionDAO.getInstance().persist(Ub1);
	  Pl1.setGeoposicion(Ub1);
	  PuntoLimpio result=PuntoLimpioDAO.getInstance().persist(Pl1);
	  System.out.println(result);
	  
	  PuntoLimpio Pl2 = new PuntoLimpio();
	  Pl2.setNombre("Oeste");
	  Pl2.setKgTope(900);
	  Pl2.setKgAcumulados(0);
	  Pl2.setCalle("Viamonte");
	  Pl2.setNumero(150);
	  Ubicacion Ub2=new Ubicacion();
	  Ub2.setLatitud(-37.326120);
	  Ub2.setLongitud(-59.151501);
	  Ub=UbicacionDAO.getInstance().persist(Ub2);
	  Pl2.setGeoposicion(Ub2);
	  result=PuntoLimpioDAO.getInstance().persist(Pl2);
	  System.out.println(result);

	  PuntoLimpio Pl3 = new PuntoLimpio();
	  Pl3.setNombre("Este");
	  Pl3.setKgTope(1200);
	  Pl3.setKgAcumulados(0);
	  Pl3.setCalle("Marconi");
	  Pl3.setNumero(1760);
	  Ubicacion Ub3=new Ubicacion();
	  Ub3.setLatitud(-37.316146);
	  Ub3.setLongitud(-59.121933);
	  Ub=UbicacionDAO.getInstance().persist(Ub3);
	  Pl3.setGeoposicion(Ub3);
	  result=PuntoLimpioDAO.getInstance().persist(Pl3);
	  System.out.println(result);

	  PuntoLimpio Pl4 = new PuntoLimpio();
	  Pl4.setNombre("Sur");
	  Pl4.setKgTope(1200);
	  Pl4.setKgAcumulados(0);
	  Pl4.setCalle("Constitucion");
	  Pl4.setNumero(260);
	  Ubicacion Ub4=new Ubicacion();
	  Ub4.setLatitud(-37.333691);
	  Ub4.setLongitud(-59.136427);
	  Ub=UbicacionDAO.getInstance().persist(Ub4);
	  Pl4.setGeoposicion(Ub4);
	  result=PuntoLimpioDAO.getInstance().persist(Pl4);
	  System.out.println(result);

	}
	public void crearOng() {
		Ong O1=new Ong();
		O1.setNombre("Cartoneros Tandil");
		Ong result=OngDAO.getInstance().persist(O1);
        System.out.println(result);

		Ong O2=new Ong();
		O2.setNombre("JANO");
		result=OngDAO.getInstance().persist(O2);
		System.out.println(result);

		Ong O3=new Ong();
		O3.setNombre("Mesa Solidaria");
		result=OngDAO.getInstance().persist(O3);
		System.out.println(result);
		
	}
	public void crearResiduos() {
		Residuo res1=new Residuo();
		res1.setNombre("Vidrio");
		res1.setValorKg(50);
		Residuo result=ResiduoDAO.getInstance().persist(res1);
		System.out.println(result);

		Residuo res2=new Residuo();
		res2.setNombre("Plastico");
		res2.setValorKg(30);
		result=ResiduoDAO.getInstance().persist(res2);
		System.out.println(result);
		
		Residuo res3=new Residuo();
		res3.setNombre("Carton");
		res3.setValorKg(30);
		result=ResiduoDAO.getInstance().persist(res3);
		System.out.println(result);

		Residuo res4=new Residuo();
		res4.setNombre("Aluminio");
		res4.setValorKg(100);
		result=ResiduoDAO.getInstance().persist(res4);
		System.out.println(result);
	}
	public void crearCamiones() {
		Camion c1 =new Camion();
		c1.setMarca("Merecedes");
		c1.setPatente("AAA111");
		c1.setCapacidad(1000);
		c1.setCapActualaCero();
		Camion result=CamionDAO.getInstance().persist(c1);
		System.out.println(result);

		Camion c2 =new Camion();
		c2.setMarca("Scania");
		c2.setPatente("BBB222");
		c2.setCapacidad(1000);
		c2.setCapActualaCero();
		result=CamionDAO.getInstance().persist(c2);
		System.out.println(result);

		Camion c3 =new Camion();
		c3.setMarca("Ford");
		c3.setPatente("CCC333");
		c3.setCapacidad(1000);
		c3.setCapActualaCero();
		result=CamionDAO.getInstance().persist(c3);
		System.out.println(result);

	}
	public void crearDonaciones() {
		
	}
	public void crearRecolecciones() {
		
	}

}
