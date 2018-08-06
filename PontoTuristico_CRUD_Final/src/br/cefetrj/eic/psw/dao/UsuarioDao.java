package br.cefetrj.eic.psw.dao;

import java.util.List;

import br.cefetrj.eic.psw.models.Usuario;

public interface UsuarioDao {
	public void inserirAtualizar(Usuario x);
	public void excluir(Usuario x);
	public Usuario buscar(Long cod);
	public List<Usuario> buscarTodos();
	public List<Usuario> buscarPorNome(String name);
	public List<Usuario> buscarPorLogin(String login);


}
