package br.cefetrj.eic.psw.dao;

import javax.persistence.EntityManager;

import br.cefetrj.eic.psw.dao.jpa.PontoTuristicoDaoImpl;
import br.cefetrj.eic.psw.dao.jpa.RestauranteDaoImpl;
import br.cefetrj.eic.psw.dao.jpa.UsuarioDaoImpl;

public class DaoFactory {

	private static EntityManager em;
	
	public static PontoTuristicoDao criarPontoDao() {
		return new PontoTuristicoDaoImpl(em);
		
	}
	
	public static RestauranteDao criarRestauranteDao() {
		return new RestauranteDaoImpl(em);
	}
	
	public static UsuarioDao criarUsuarioDao() {
		return new UsuarioDaoImpl(em);
	}
	
	
}
