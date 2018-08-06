package br.cefetrj.eic.psw.servico.impl;

import java.util.List;

import br.cefetrj.eic.psw.dao.DaoFactory;
import br.cefetrj.eic.psw.dao.RestauranteDao;
import br.cefetrj.eic.psw.dao.jpa.EM;
import br.cefetrj.eic.psw.models.Restaurante;
import br.cefetrj.eic.psw.servico.RestauranteService;
import br.cefetrj.eic.psw.servico.ServicoException;

public class RestauranteServiceImpl implements RestauranteService {

	private RestauranteDao dao;
	
	public RestauranteServiceImpl() {
		dao = DaoFactory.criarRestauranteDao();
	}
	
	@Override
	public void inserirRestaurante(Restaurante x) throws ServicoException {
		
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}

	@Override
	public void excluir(Restaurante x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}

	@Override
	public Restaurante buscar(Long cod) {
		return dao.buscar(cod);
	}

	@Override
	public List<Restaurante> buscarTodos() {
		return dao.buscarTodos();
	}


}
