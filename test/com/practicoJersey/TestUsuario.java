package com.practicoJersey;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.practicoEspecial.Acopio;
import com.practicoEspecial.AcopioDAO;
import com.practicoEspecial.EMF;
import com.practicoEspecial.Recoleccion;
import com.practicoEspecial.Usuario;
import com.practicoEspecial.UsuarioDAO;

public class TestUsuario {

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
	public void testDatosUsuario() {
		listDatosUsuario(2);
		System.out.println("--------------------------------------");
		System.out.println("**************************************");
		System.out.println("--------------------------------------");
		listDatosUsuario(4);
		System.out.println("--------------------------------------");
		System.out.println("**************************************");
		System.out.println("--------------------------------------");
	}
	@Test
	public void testConsultaAcopiosRealizadosPorUsuario() {
		testConsultasAcopiosByIdUser(2);
		System.out.println("--------------------------------------");
		System.out.println("**************************************");
		System.out.println("--------------------------------------");
		testConsultasAcopiosByIdUser(3);
		System.out.println("--------------------------------------");
		System.out.println("**************************************");
		System.out.println("--------------------------------------");
	}
	@Test
	public void testAcopiosRealizadoPorUsuarioAndFechas() {
		ConsultaUsuarioAndFechas(2,Date.valueOf("2019-01-01"),Date.valueOf("2019-12-01"));
		System.out.println("--------------------------------------");
		System.out.println("**************************************");
		System.out.println("--------------------------------------");
		ConsultaUsuarioAndFechas(2,Date.valueOf("2018-01-01"),Date.valueOf("2018-12-01"));
		System.out.println("--------------------------------------");
		System.out.println("**************************************");
		System.out.println("--------------------------------------");
	}
	@Test
	public void ConsultaLugaresAcopioPorUsuario() {
		testConsultaRecoleccionesByUser(2);		
		System.out.println("--------------------------------------");
		System.out.println("**************************************");
		System.out.println("--------------------------------------");
		testConsultaRecoleccionesByUser(4);		
		System.out.println("--------------------------------------");
		System.out.println("**************************************");
		System.out.println("--------------------------------------");
	}
	@Test
	public void TestAhorroPorUsuario() {
		ConsultaAhorroByIdUser(2);		
		System.out.println("--------------------------------------");
		System.out.println("**************************************");
		System.out.println("--------------------------------------");
		ConsultaAhorroByIdUser(3);				
		System.out.println("--------------------------------------");
		System.out.println("**************************************");
		System.out.println("--------------------------------------");
	}

	@Test
	public void TestAhorroPorUsuarioEnRangoFecha() {
		ConsultaAhorroByIdUserAndFechas(2,Date.valueOf("2019-01-01"),Date.valueOf("2019-12-01"));		
		System.out.println("--------------------------------------");
		System.out.println("**************************************");
		System.out.println("--------------------------------------");
		ConsultaAhorroByIdUserAndFechas(3,Date.valueOf("2018-01-01"),Date.valueOf("2018-12-01"));				
		System.out.println("--------------------------------------");
		System.out.println("**************************************");
		System.out.println("--------------------------------------");
	}

	@Test
	   public void TestConsultaAporteByIdUser() {
		ConsultaAporteByIdUser(2);		
		System.out.println("--------------------------------------");
		System.out.println("**************************************");
		System.out.println("--------------------------------------");
		ConsultaAporteByIdUser(3);				
		System.out.println("--------------------------------------");
		System.out.println("**************************************");
		System.out.println("--------------------------------------");
	}
	
	/**
	 * 
	 * @param id Numero identificador de usuario, clave obtenida al persistir el usuario en la base de datos
	 * 
	 */
	public void listDatosUsuario(int id) {
	    Usuario user=UsuarioDAO.getInstance().findById(id);
	    System.out.println("Nombre: "+user.getNombre() + " "+user.getApellido());
	    System.out.println("Direccion: "+user.getCalle()+ " "+user.getNumero());
	    System.out.println("E-Mail: "+user.getEmail());

	}
	/**
	 * 
	 * @param id Identificador de Usuario
	 * La funcion lista todos los acopios realizados por un usuario (obtenido por su ID)
	 * 
	 */
	public void testConsultasAcopiosByIdUser(int id) {
	    Usuario user=UsuarioDAO.getInstance().findById(id);
	    List<Acopio> Acopios=AcopioDAO.getInstance().findByIdUsuario(id);
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
	/**
	 * 
	 * @param id Numero identificador de usuario, clave obtenida al persistir el usuario en la base de datos
	 * @param FechI  Fecha inicial de la busqueda Formato YYYY/MM/DD
	 * @param FechF  Fecha final de la busqueda Formato YYYY/MM/DD
	 * La funcion lista todos los acopios realizados por un usuario (obtenido por su ID) entre las fechas FechI y FechF
	 * 
	 */
	public void ConsultaUsuarioAndFechas(int id,Date FechI,Date FechF) {
    Usuario user=UsuarioDAO.getInstance().findById(id);
    if (user!=null) {
    	System.out.println("Usuario: "+user.getNombre()+" "+user.getApellido());
    	System.out.println("Acopios Realizados desde "+FechI+" hasta: "+FechF);
    	List<Acopio> acopios=AcopioDAO.getInstance().findByIdUsuarioAndfechas(2,FechI,FechF);
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
	/**
	 * 
	 * @param id Identificador unico para usuario
	 * La consulta devuelve los lugares de acopios sugeridos a un usuario segun su geoubicacion
	 * 
	 */
	
	public void testConsultaRecoleccionesByUser(int id) {
    Usuario user=UsuarioDAO.getInstance().findById(id);
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
	
	public void ConsultaAhorroByIdUser(int id) {
		Usuario user=UsuarioDAO.getInstance().findById(id);
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
			System.out.println("El usuario no existe");
		}
	}
/**
 * 	
 * @param id  Identifiacdor de un Usuario en la Base de datos
 * @param FechI Fecha desde donde comienza la busqueda de acopios realizados
 * @param FechF Fecha hasta donde termina la busqueda de acopios realizados
 * 
 */
	public void ConsultaAhorroByIdUserAndFechas(int id, Date FechI,Date FechF) {
		Usuario user=UsuarioDAO.getInstance().findById(id);
		int cant=0;
		if (user!=null) {
			List<Acopio> acopios =AcopioDAO.getInstance().findByIdUsuarioAndfechas(user.getId(),FechI,FechF);
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
	   public void ConsultaAporteByIdUser(int id) {
		   Hashtable<String, Integer> result=UsuarioDAO.getInstance().aporteParaOngs(id);
		   System.out.println("Residuos aportados y Dinero equivalente");
		   System.out.println(result);
		   
	   }
}
