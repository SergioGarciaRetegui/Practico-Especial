package com.practicoJersey;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;

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

public class TestIniciDataBase {

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
	    crearRecolecciones();
	    crearAcopios();
	    crearDonaciones();
	}
	
	public void crearUsuarios() {
		  Usuario user1=new Usuario();
		  user1.setApellido("Perez");
		  user1.setNombre("Jose");
		  user1.setDni(111111);
		  user1.setEmail("user1@email.com");
		  user1.setCalle("Yrigoyen");
		  user1.setNumero(1253);
		  user1.setLatGeoposicion(-37.318876);
	      user1.setLongGeoposicion(-59.142485);
		  Usuario result=UsuarioDAO.getInstance().persist(user1);
		  System.out.println(result);
	  
		  Usuario user2=new Usuario();
		  user2.setApellido("Gonzales");
		  user2.setNombre("Pedro");
		  user2.setDni(222222);
		  user2.setEmail("user2@email.com");
		  user2.setCalle("Pinto");
		  user2.setNumero(646);
		  user2.setLatGeoposicion(-37.327826);
	      user2.setLongGeoposicion(-59.136778);
		  result= UsuarioDAO.getInstance().persist(user2);
		  System.out.println(result);

		  Usuario user3=new Usuario();
		  user3.setApellido("Lopez");
		  user3.setNombre("Miguel");
		  user3.setDni(333333);
		  user3.setEmail("user3@email.com");
		  user3.setCalle("Figueroa");
		  user3.setNumero(853);
		  user3.setLatGeoposicion(-37.308679);
	      user3.setLongGeoposicion(-59.150263);
		  result=UsuarioDAO.getInstance().persist(user3);
		  System.out.println(result);

		  Usuario user4=new Usuario();
		  user4.setApellido("Garcia");
		  user4.setNombre("Eduardo");
		  user4.setDni(444444);
		  user4.setEmail("user4@email.com");
		  user4.setCalle("Colombia");
		  user4.setNumero(540);
		  user4.setLatGeoposicion(-37.319004);
	      user4.setLongGeoposicion(-59.114569);
		  result=UsuarioDAO.getInstance().persist(user4);
		  System.out.println(result);

		  Usuario user5=new Usuario();
		  user5.setApellido("Torres");
		  user5.setNombre("Luciana");
		  user5.setDni(555555);
		  user5.setEmail("user5@email.com");
		  user5.setCalle("Roca");
		  user5.setNumero(602);
		  user5.setLatGeoposicion(-37.322178);
	      user5.setLongGeoposicion(-59.126541);
		  result=UsuarioDAO.getInstance().persist(user5);
		  System.out.println(result);

		  Usuario user6=new Usuario();
		  user6.setApellido("Nartinez");
		  user6.setNombre("Josefina");
		  user6.setDni(666666);
		  user6.setEmail("user6@email.com");
		  user6.setCalle("Montiel");
		  user6.setNumero(1223);
		  user6.setLatGeoposicion(-37.313714);
	      user6.setLongGeoposicion(-59.127701);
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
		  Pl1.setLatGeoposicion(-37.303301);
		  Pl1.setLongGeoposicion(-59.147978);
		  PuntoLimpio result=PuntoLimpioDAO.getInstance().persist(Pl1);
		  System.out.println(result);
		  
		  PuntoLimpio Pl2 = new PuntoLimpio();
		  Pl2.setNombre("Oeste");
		  Pl2.setKgTope(900);
		  Pl2.setKgAcumulados(0);
		  Pl2.setCalle("Viamonte");
		  Pl2.setNumero(150);
		  Pl2.setLatGeoposicion(-37.326120);
		  Pl2.setLongGeoposicion(-59.151501);
		  result=PuntoLimpioDAO.getInstance().persist(Pl2);
		  System.out.println(result);

		  PuntoLimpio Pl3 = new PuntoLimpio();
		  Pl3.setNombre("Este");
		  Pl3.setKgTope(1200);
		  Pl3.setKgAcumulados(0);
		  Pl3.setCalle("Marconi");
		  Pl3.setNumero(1760);
		  Pl3.setLatGeoposicion(-37.316146);
		  Pl3.setLongGeoposicion(-59.121933);
		  result=PuntoLimpioDAO.getInstance().persist(Pl3);
		  System.out.println(result);

		  PuntoLimpio Pl4 = new PuntoLimpio();
		  Pl4.setNombre("Sur");
		  Pl4.setKgTope(1200);
		  Pl4.setKgAcumulados(0);
		  Pl4.setCalle("Constitucion");
		  Pl4.setNumero(260);
		  Pl4.setLatGeoposicion(-37.333691);
		  Pl4.setLongGeoposicion(-59.136427);
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
		public void crearRecolecciones() {
			Recoleccion r1=new Recoleccion();
			r1.setDia("Lunes");
			r1.setHoraInic(Time.valueOf("10:00:00"));
			r1.setHoraFin(Time.valueOf("10:15:00"));
			r1.setCamionRecolector(18);
			r1.setPuntoRecoleccion(9);
			Recoleccion result=RecoleccionDAO.getInstance().persist(r1);
			System.out.println(result);

			
			Recoleccion r2=new Recoleccion();
			r2.setDia("Lunes");
			r2.setHoraInic(Time.valueOf("10:40:00"));
			r2.setHoraFin(Time.valueOf("10:55:00"));
			r2.setCamionRecolector(18);
			r2.setPuntoRecoleccion(10);
			result=RecoleccionDAO.getInstance().persist(r2);
			System.out.println(result);

			Recoleccion r3=new Recoleccion();
			r3.setDia("Lunes");
			r3.setHoraInic(Time.valueOf("11:10:00"));
			r3.setHoraFin(Time.valueOf("11:30:00"));
			r3.setCamionRecolector(18);
			r3.setPuntoRecoleccion(8);
			result=RecoleccionDAO.getInstance().persist(r3);
			System.out.println(result);

			Recoleccion r4=new Recoleccion();
			r4.setDia("Lunes");
			r4.setHoraInic(Time.valueOf("11:50:00"));
			r4.setHoraFin(Time.valueOf("12:05:00"));
			r4.setCamionRecolector(18);
			r4.setPuntoRecoleccion(7);
			result=RecoleccionDAO.getInstance().persist(r4);
			System.out.println(result);
			
			Recoleccion r5=new Recoleccion();
			r5.setDia("Miercoles");
			r5.setHoraInic(Time.valueOf("10:00:00"));
			r5.setHoraFin(Time.valueOf("10:15:00"));
			r5.setCamionRecolector(19);
			r5.setPuntoRecoleccion(7);
			result=RecoleccionDAO.getInstance().persist(r5);
			System.out.println(result);

			
			Recoleccion r6=new Recoleccion();
			r6.setDia("Miercoles");
			r6.setHoraInic(Time.valueOf("10:40:00"));
			r6.setHoraFin(Time.valueOf("10:55:00"));
			r6.setCamionRecolector(19);
			r6.setPuntoRecoleccion(8);
			result=RecoleccionDAO.getInstance().persist(r6);
			System.out.println(result);

			Recoleccion r7=new Recoleccion();
			r7.setDia("Miercoles");
			r7.setHoraInic(Time.valueOf("11:10:00"));
			r7.setHoraFin(Time.valueOf("11:30:00"));
			r7.setCamionRecolector(19);
			r7.setPuntoRecoleccion(10);
			result=RecoleccionDAO.getInstance().persist(r7);
			System.out.println(result);

			Recoleccion r8=new Recoleccion();
			r8.setDia("Miercoles");
			r8.setHoraInic(Time.valueOf("11:50:00"));
			r8.setHoraFin(Time.valueOf("12:05:00"));
			r8.setCamionRecolector(19);
			r8.setPuntoRecoleccion(9);
			result=RecoleccionDAO.getInstance().persist(r8);
			System.out.println(result);

			Recoleccion r9=new Recoleccion();
			r9.setDia("Viernes");
			r9.setHoraInic(Time.valueOf("10:00:00"));
			r9.setHoraFin(Time.valueOf("10:15:00"));
			r9.setCamionRecolector(20);
			r9.setPuntoRecoleccion(9);
			result=RecoleccionDAO.getInstance().persist(r9);
			System.out.println(result);

			
			Recoleccion r10=new Recoleccion();
			r10.setDia("Viernes");
			r10.setHoraInic(Time.valueOf("10:40:00"));
			r10.setHoraFin(Time.valueOf("10:55:00"));
			r10.setCamionRecolector(20);
			r10.setPuntoRecoleccion(10);
			result=RecoleccionDAO.getInstance().persist(r10);
			System.out.println(result);

			Recoleccion r11=new Recoleccion();
			r11.setDia("Viernes");
			r11.setHoraInic(Time.valueOf("11:10:00"));
			r11.setHoraFin(Time.valueOf("11:30:00"));
			r11.setCamionRecolector(20);
			r11.setPuntoRecoleccion(8);
			result=RecoleccionDAO.getInstance().persist(r11);
			System.out.println(result);

			Recoleccion r12=new Recoleccion();
			r12.setDia("Viernes");
			r12.setHoraInic(Time.valueOf("11:50:00"));
			r12.setHoraFin(Time.valueOf("12:05:00"));
			r12.setCamionRecolector(20);
			r12.setPuntoRecoleccion(7);
			result=RecoleccionDAO.getInstance().persist(r12);
			System.out.println(result);

		}
		public void crearAcopios() {
			Acopio ac1=new Acopio();
			ac1.setFechaAcopio(Date.valueOf("2019-09-05"));
			ac1.setUser(1);
			ac1.setReciclable(14);
			ac1.setCant(10);
			ac1.setPuntlimpio(10);
			Acopio result=AcopioDAO.getInstance().persist(ac1);
			System.out.println(result);

			Acopio ac2=new Acopio();
			ac2.setFechaAcopio(Date.valueOf("2019-09-10"));
			ac2.setUser(1);
			ac2.setReciclable(15);
			ac2.setCant(5);
			ac2.setPuntlimpio(10);
			result=AcopioDAO.getInstance().persist(ac2);
			System.out.println(result);

			Acopio ac3=new Acopio();
			ac3.setFechaAcopio(Date.valueOf("2019-09-12"));
			ac3.setUser(2);
			ac3.setReciclable(14);
			ac3.setCant(10);
			ac3.setPuntlimpio(8);
			result=AcopioDAO.getInstance().persist(ac3);
			System.out.println(result);

			Acopio ac4=new Acopio();
			ac4.setFechaAcopio(Date.valueOf("2019-09-22"));
			ac4.setUser(2);
			ac4.setReciclable(16);
			ac4.setCant(4);
			ac4.setPuntlimpio(8);
			result=AcopioDAO.getInstance().persist(ac4);
			System.out.println(result);

			Acopio ac5=new Acopio();
			ac5.setFechaAcopio(Date.valueOf("2019-09-14"));
			ac5.setUser(3);
			ac5.setReciclable(14);
			ac5.setCant(10);
			ac5.setPuntlimpio(7);
			result=AcopioDAO.getInstance().persist(ac5);
			System.out.println(result);

			Acopio ac6=new Acopio();
			ac6.setFechaAcopio(Date.valueOf("2019-09-26"));
			ac6.setUser(3);
			ac6.setReciclable(14);
			ac6.setCant(10);
			ac6.setPuntlimpio(7);
			result=AcopioDAO.getInstance().persist(ac6);
			System.out.println(result);
	}
		
		public void crearDonaciones() {
			Donacion dn1= new Donacion();
			dn1.setCant(4);
			dn1.setOng(11);
			dn1.setFecha(Date.valueOf("2019-10-02"));
			dn1.setReciclable(16);
			Donacion result= DonacionDAO.getInstance().persist(dn1);
			System.out.println(result);

			Donacion dn2= new Donacion();
			dn2.setCant(10);
			dn2.setOng(13);
			dn2.setFecha(Date.valueOf("2019-10-03"));
			dn2.setReciclable(14);
			result= DonacionDAO.getInstance().persist(dn2);
			System.out.println(result);
			
		}

}
