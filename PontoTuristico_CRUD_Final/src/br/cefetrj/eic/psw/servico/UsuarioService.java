package br.cefetrj.eic.psw.servico;

import java.util.List;

import br.cefetrj.eic.psw.models.Usuario;

public interface UsuarioService {

	public void inserirUsuario(Usuario x) throws ServicoException;
	public void excluir(Usuario x);
	public Usuario buscar(Long cod);
	public List<Usuario> buscarTodos();
	
}
