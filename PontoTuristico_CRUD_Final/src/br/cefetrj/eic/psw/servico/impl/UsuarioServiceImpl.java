package br.cefetrj.eic.psw.servico.impl;

import java.util.List;

import br.cefetrj.eic.psw.dao.DaoFactory;
import br.cefetrj.eic.psw.dao.UsuarioDao;
import br.cefetrj.eic.psw.dao.jpa.EM;
import br.cefetrj.eic.psw.models.Usuario;
import br.cefetrj.eic.psw.servico.ServicoException;
import br.cefetrj.eic.psw.servico.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioDao dao;
	
	public UsuarioServiceImpl() {
		dao = DaoFactory.criarUsuarioDao();
	}
	
	@Override
	public void inserirUsuario(Usuario x) throws ServicoException {
		
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}

	@Override
	public void excluir(Usuario x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}

	@Override
	public Usuario buscar(Long cod) {
		return dao.buscar(cod);
	}

	@Override
	public List<Usuario> buscarTodos() {
		return dao.buscarTodos();
	}


}
