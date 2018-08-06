package br.cefetrj.eic.psw.servico.impl;

import java.util.List;

import br.cefetrj.eic.psw.dao.DaoFactory;
import br.cefetrj.eic.psw.dao.PontoTuristicoDao;
import br.cefetrj.eic.psw.dao.jpa.EM;
import br.cefetrj.eic.psw.models.PontoTuristico;
import br.cefetrj.eic.psw.servico.PontoTuristicoService;
import br.cefetrj.eic.psw.servico.ServicoException;

public class PontoTuristicoServiceImpl implements PontoTuristicoService {

	private PontoTuristicoDao dao;
	
	public PontoTuristicoServiceImpl() {
		dao = DaoFactory.criarPontoDao();
	}
	
	@Override
	public void inserirPonto(PontoTuristico x) throws ServicoException {
		
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}

	@Override
	public void excluir(PontoTuristico x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}

	@Override
	public PontoTuristico buscar(Long cod) {
		return dao.buscar(cod);
	}

	@Override
	public List<PontoTuristico> buscarTodos() {
		return dao.buscarTodos();
	}
	
	@Override
	public List<PontoTuristico> buscarPorNome(String trechoNome) {
		return dao.buscarPorNome(trechoNome);
	}


}
