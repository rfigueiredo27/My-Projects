package br.cefetrj.eic.psw.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	
private static EntityManagerFactory emf;
	
	static{
		emf = null;
		buildFactory();
	}
	
	private static boolean buildFactory(){
		if(emf == null){
			try{
				emf = Persistence.createEntityManagerFactory("meujpa");
			} catch (Throwable e){
				e.printStackTrace();
			}
		}
		return emf != null;
	}
	
	public static EntityManager getConector(){
		return (buildFactory() ? emf.createEntityManager() : null);
	}
}
