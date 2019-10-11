package com.practicoEspecial;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

public class AcopioDAO implements DAO<Acopio,Integer>{

	private static AcopioDAO daoAcopio;

	private AcopioDAO() {
	}

	public static AcopioDAO getInstance() {
		if(daoAcopio==null)
			daoAcopio=new AcopioDAO();
		return daoAcopio;
	}

	@Override
	public Acopio findById(Integer id) {
		
		EntityManager entityManager=EMF.createEntityManager();
		Acopio acopio=entityManager.find(Acopio.class, id);
		entityManager.close();
		return acopio;
	
	}

	public List<Acopio> findByIdUsuario(Integer id) {
        List<Acopio> result=new ArrayList<Acopio>();
 		EntityManager entityManager=EMF.createEntityManager();
		result=entityManager.createQuery("SELECT a FROM Acopio a INNER JOIN a.user u WHERE u.id = :idUser ").setParameter("idUser", id).getResultList();
		entityManager.close();
		return result;
	}
	
	public List<Residuo>FindTipoDepositadosByID(int id){
		EntityManager entityManager=EMF.createEntityManager();
		List<Residuo> residuos=entityManager.createQuery("SELECT DISTINCT a.reciclable FROM Acopio a INNER JOIN a.user u WHERE u.id= :idUser").setParameter("idUser", id).getResultList();
		entityManager.close();
		return residuos;
		
	}

	public int cantResidByIdUserAndIdResiduo(int idUser, int idRes){
		EntityManager entityManager=EMF.createEntityManager();
		Long result=(Long) entityManager.createQuery("SELECT SUM(a.cant) FROM Acopio a INNER JOIN a.user u ON (u.id= :idUser) INNER JOIN a.reciclable r ON(r.id=:idRes)").setParameter("idUser", idUser).setParameter("idRes",idRes).getSingleResult();
		entityManager.close();
		return result.intValue();
		
	}

	public List<Residuo>FindTipoDepositadosByIDandFechas(int id,Date FechaI, Date FechaF){
		EntityManager entityManager=EMF.createEntityManager();
		List<Residuo> residuos=entityManager.createQuery("SELECT DISTINCT a.reciclable FROM Acopio a INNER JOIN a.user u WHERE u.id= :idUser AND a.fechaAcopio BETWEEN :f1 AND :f2").setParameter("idUser", id).setParameter("f1",FechaI).setParameter("f2",FechaF).getResultList();
		entityManager.close();
		return residuos;
		
	}

	public List<Acopio> findByIdUsuarioAndfechas(Integer id,Date FechaI, Date FechaF){
		EntityManager entityManager=EMF.createEntityManager();
		List<Acopio> Acopios=entityManager.createQuery("SELECT a FROM Acopio a INNER JOIN a.user u WHERE u.id= :idUser AND a.fechaAcopio BETWEEN :f1 AND :f2").setParameter("idUser", id).setParameter("f1",FechaI).setParameter("f2",FechaF).getResultList();
		entityManager.close();
		return Acopios;
	}	

	public List<Residuo> findByIdPuntoLimpioAndfechas(Integer id,Date FechaI, Date FechaF){
		EntityManager entityManager=EMF.createEntityManager();
		List<Residuo> resid=entityManager.createQuery("SELECT a.reciclable FROM Acopio a INNER JOIN a.puntlimpio p WHERE p.id= :idPL AND a.fechaAcopio BETWEEN :f1 AND :f2").setParameter("idPL", id).setParameter("f1",FechaI).setParameter("f2",FechaF).getResultList();
		entityManager.close();
		return resid;
	}	

	public List<Acopio> historialByIdPuntoLimpio(Integer id){
		EntityManager entityManager=EMF.createEntityManager();
		List<Acopio> acopios=entityManager.createQuery("SELECT a FROM Acopio a INNER JOIN a.puntlimpio p WHERE p.id= :idPL").setParameter("idPL", id).getResultList();
		entityManager.close();
		return acopios;
	}	

	
	@Override
	public Acopio persist(Acopio acopio) {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(acopio);
		entityManager.getTransaction().commit();
		entityManager.close();
		return acopio;
	}

	@Override
	public List<Acopio> findAll() {
		EntityManager entityManager=EMF.createEntityManager();
		List<Acopio> Acopios=entityManager.createQuery("SELECT a FROM Acopio a").getResultList();
		entityManager.close();
		return Acopios;
	}
	public List<Resultado> RankingPL(){
		List<Resultado> result=new ArrayList<Resultado>();
		EntityManager entityManager=EMF.createEntityManager();
		List<String> AcopioSt=entityManager.createQuery("SELECT p.nombre FROM Acopio a INNER JOIN a.puntlimpio p GROUP BY p.nombre ORDER BY SUM(a.cant)").getResultList();
		List<Long> AcopioInt=entityManager.createQuery("SELECT SUM(a.cant) AS kg FROM Acopio a INNER JOIN a.puntlimpio p GROUP BY p.nombre ORDER BY SUM(a.cant) DESC").getResultList();
		for(int i=0;i<AcopioInt.size();i++) {
			Resultado aux=new Resultado("Punto Limpio",AcopioSt.get(i),"Cantidad",AcopioInt.get(i));
			result.add(aux);
		}
		entityManager.close();
		return result;
	}

	public List<Resultado> TotalResiduosProcesados(){
		List<Resultado> result=new ArrayList<Resultado>();
		EntityManager entityManager=EMF.createEntityManager();
		List<String> AcopioSt=entityManager.createQuery("SELECT r.nombre FROM Acopio a INNER JOIN a.reciclable r GROUP BY r.nombre ORDER BY SUM(a.cant)").getResultList();
		List<Long> AcopioInt=entityManager.createQuery("SELECT SUM(a.cant) AS kg FROM Acopio a INNER JOIN a.reciclable r GROUP BY r.nombre ORDER BY SUM(a.cant) DESC").getResultList();
		for(int i=0;i<AcopioInt.size();i++) {
			Resultado aux=new Resultado("Residuo",AcopioSt.get(i),"Cantidad (Kg)",AcopioInt.get(i));
			result.add(aux);
		}
		entityManager.close();
		return result;
	}

	public List<Resultado> TotalResiduosProcesadosByFecha(Date FechaI,Date FechaF){
		List<Resultado> result=new ArrayList<Resultado>();
		EntityManager entityManager=EMF.createEntityManager();
		List<String> AcopioSt=entityManager.createQuery("SELECT r.nombre FROM Acopio a INNER JOIN a.reciclable r WHERE a.fechaAcopio BETWEEN :f1 AND :f2 GROUP BY r.nombre ORDER BY SUM(a.cant)").setParameter("f1",FechaI).setParameter("f2",FechaF).getResultList();
		List<Long> AcopioInt=entityManager.createQuery("SELECT SUM(a.cant) AS kg FROM Acopio a INNER JOIN a.reciclable r WHERE a.fechaAcopio BETWEEN :f1 AND :f2 GROUP BY r.nombre ORDER BY SUM(a.cant) DESC").setParameter("f1",FechaI).setParameter("f2",FechaF).getResultList();
		for(int i=0;i<AcopioInt.size();i++) {
			Resultado aux=new Resultado("Residuo",AcopioSt.get(i),"Cantidad (Kg)",AcopioInt.get(i));
			result.add(aux);
		}
		entityManager.close();
		return result;
	}
	
	@Override
	public boolean delete(Integer id) {
		EntityManager entityManager=EMF.createEntityManager();
		Acopio acopio=entityManager.find(Acopio.class, id);
		entityManager.getTransaction().begin();
        entityManager.remove(acopio);
        entityManager.clear();
        entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}

	@Override
	public Acopio update(Integer id, Acopio entity) {
		throw new UnsupportedOperationException();
	}



public class Resultado{
	String Campo;
	String ValorCampo;
	String CampoValor;
	Long Valor;
	public Resultado(String c,String vc,String cv,Long v) {
		this.Campo=c;
		this.ValorCampo=vc;
		this.CampoValor=cv;
		this.Valor=v;
	}
	public void setCampo(String c) {
		this.Campo=c;
	}
	public void setValor(Long v) {
		this.Valor=v;
	}
	public void setValorCampo(String c) {
		this.ValorCampo=c;
	}
	public void setCampoValor(String v) {
		this.CampoValor=v;
	}
	public String getValorCampo() {
		return this.ValorCampo;
	}
	public String getCampoValor() {
		return this.CampoValor;
	}
	public String getCampo() {
		return this.Campo;
	}
	public Long getValor() {
		return this.Valor;
	}

	@Override
	public String toString() {
		return "{"+this.Campo+ ": "+this.ValorCampo+" - "+this.CampoValor+": "+this.Valor+"}";
	}
}
}