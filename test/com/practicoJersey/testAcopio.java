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
import com.practicoEspecial.Ubicacion;
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
	/*
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
	}*/
	/*
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
	    	  Ong ong=(Ong)itPl.next();
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
*/
	/*
	@Test
	public void testlistados() {
		System.out.println(UsuarioDAO.getInstance().findAll());
		System.out.println(OngDAO.getInstance().findAll());
		System.out.println(ResiduoDAO.getInstance().findAll());
		System.out.println(CamionDAO.getInstance().findAll());
		System.out.println(PuntoLimpioDAO.getInstance().findAll());
		System.out.println(RecoleccionDAO.getInstance().findAll());
		System.out.println(DonacionDAO.getInstance().findAll());
	}
*/

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
		dn1.setReciclable(16);
		Donacion result= DonacionDAO.getInstance().persist(dn1);
		System.out.println(result);

		Donacion dn2= new Donacion();
		dn2.setCant(10);
		dn2.setOng(13);
		dn2.setReciclable(14);
		result= DonacionDAO.getInstance().persist(dn2);
		System.out.println(result);
		
	}
//------------------------------------------------------------------------------------
	@Test
	public void testConsultaUsuarioAndFechas() {
    Usuario user=UsuarioDAO.getInstance().findById(2);
    if (user!=null) {
    	System.out.println("Usuario: "+user.getNombre()+" "+user.getApellido());
    	System.out.println("Acopios Realizados desde "+Date.valueOf("2019-01-01")+" hasta: "+Date.valueOf("2019-12-01"));
    	List<Acopio> acopios=AcopioDAO.getInstance().findByIdUsuarioAndfechas(2, Date.valueOf("2019-01-01"), Date.valueOf("2019-12-01"));
    	if (acopios.size()>0) {
    		Iterator it=acopios.iterator();
    		Acopio aux;
    		while(it.hasNext()) {
    			aux=(Acopio)it.next();
    			System.out.println("Fecha: "+aux.getFechaAcopio());
    			System.out.println("Residuo: "+aux.getReciclable().getNombre());
    			System.out.println("Cantidad: "+aux.getCant()+" Kg");
    			System.out.println("Lugar de Deposito: "+aux.getPuntlimpio().getNombre());
    			System.out.println("-----------------------------------------");

    		}
			System.out.println("--------------------------------------");
			System.out.println("**************************************");
			System.out.println("--------------------------------------");
    	}
    	else {
			System.out.println("El usuario no realizo depositos");

    	}
    }
    else {
		System.out.println("Usuario inexistente");
    	}	
	}
//----------------------------------------------------------------------------
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
    		System.out.println("*******************************************************");
    		System.out.println("-------------------------------------------------------");
    	}
    	else {
    		System.out.println("El punto limpio no tiene residuos Reciclados");	
    	}
    }    
	}
//-------------------------------------------------------------------
	@Test
	public void testConsultasAcopiosByIdUser() {
    Usuario user=UsuarioDAO.getInstance().findById(2);
    List<Acopio> Acopios=AcopioDAO.getInstance().findByIdUsuario(2);
    if(Acopios.size()>0) {
    Iterator it=Acopios.iterator();
    Acopio aux;
	System.out.println("Usuario: "+user.getNombre()+" "+user.getApellido());
	System.out.println("Acopios realizados:");
    while (it.hasNext()) {
    	aux=(Acopio)it.next();
    	System.out.println("Residuo: "+aux.getReciclable().getNombre());
    	System.out.println("Cantidad: "+aux.getCant());
    	System.out.println("Fecha de Deposicion: "+aux.getFechaAcopio());
    	System.out.println("Punto de deposicion: "+aux.getPuntlimpio().getNombre());
    	System.out.println("Direccion: "+aux.getPuntlimpio().getCalle()+" "+aux.getPuntlimpio().getNumero());
    	System.out.println("-------------------------------------------------------");
    }
    }
    else {
    	System.out.println("El usuario "+user.getNombre()+" "+user.getApellido()+" no registra acopios");
    }
	}

	@Test
	public void testConsultaRecoleccionesByUser() {
    Usuario user=UsuarioDAO.getInstance().findById(2);
    if(user!=null) {
    List<Recoleccion> recolecciones=UsuarioDAO.getInstance().recoleccionesPorGeolocalizacion(2);
    if(recolecciones.size()>0) {
    Iterator it=recolecciones.iterator();
    Recoleccion aux;
	System.out.println("Usuario: "+user.getNombre()+" "+user.getApellido());
	System.out.println("Lugares de acopios sugeridos:");
    while (it.hasNext()) {
    	aux=(Recoleccion)it.next();
    	System.out.println("Punto de Acopio: "+aux.getPuntoRecoleccion().getNombre());
    	System.out.println("Direccion: "+aux.getPuntoRecoleccion().getCalle()+" "+aux.getPuntoRecoleccion().getNumero());
    	System.out.println("Dia de retiro: "+aux.getDia());
    	System.out.println("Horario de recoleccion desde: "+aux.getHoraInic()+" hasta: "+aux.getHoraFin());
    	System.out.println("-------------------------------------------------------");
    }
    }
    else {
    	System.out.println("No hay lugares de acopio recomendados");
    }
    }
    else
    {System.out.println("El usuario no existe");}
	}
//---------------------------------------------------------------------
	@Test
	public void testEsReciclable() {
		if (ResiduoDAO.getInstance().esReciclable("Vidrio")) {
		System.out.println("El residuo es reciclable");	
		}
		else {
			System.out.println("El residuo no es reciclable");
		}
	}
//-----------------------------------------------------------------------
	@Test
	public void testVolumenAlcanzado() {
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
	}
//-----------------------------------------------------------------------
	@Test
	public void testAhorroByIdUser() {
		Usuario user=UsuarioDAO.getInstance().findById(2);
		int cant=0;
		if (user!=null) {
			List<Acopio> acopios =AcopioDAO.getInstance().findByIdUsuario(user.getId());
			if (acopios.size()>0) {
				Iterator itacopio=acopios.iterator();
				Acopio aux;
				while(itacopio.hasNext()) {
					aux=(Acopio)itacopio.next();
					cant+=aux.getCant();
				}
				System.out.println("El usuario "+user.getNombre()+" "+user.getApellido()+" ahorro "+cant+" kg en deposito de residuos");
			}
			else {
				System.out.println("El usuario "+user.getNombre()+" "+user.getApellido()+" no realizo acopios");
			}
		}
		else {
			System.out.println("El Punto limpio no existe");
		}
	}

//-----------------------------------------------------------------------
	@Test
	public void testAhorroByIdUserRangoFecha() {
		Usuario user=UsuarioDAO.getInstance().findById(2);
		int cant=0;
		if (user!=null) {
			List<Acopio> acopios =AcopioDAO.getInstance().findByIdUsuarioAndfechas(user.getId(), Date.valueOf("2019-08-31"), Date.valueOf("2019-10-31"));
			if (acopios.size()>0) {
				Iterator itacopio=acopios.iterator();
				Acopio aux;
				while(itacopio.hasNext()) {
					aux=(Acopio)itacopio.next();
					cant+=aux.getCant();
				}
				System.out.println("El usuario "+user.getNombre()+" "+user.getApellido()+" ahorro "+cant+" kg en deposito de residuos");
			}
			else {
				System.out.println("El usuario "+user.getNombre()+" "+user.getApellido()+" no realizo acopios");
			}
		}
		else {
			System.out.println("El Punto limpio no existe");
		}
	}

//-----------------------------------------------------------------------
   @Test
   public void TestConsultaAporteByIdUser() {
	   Hashtable<String, Integer> result=UsuarioDAO.getInstance().aporteParaOngs(2);
	   System.out.println("Consulta de total de Kg por residuos");
	   System.out.println(result);
	   
   }
}
