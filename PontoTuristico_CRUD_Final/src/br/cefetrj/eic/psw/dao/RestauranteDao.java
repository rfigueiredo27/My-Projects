package br.cefetrj.eic.psw.dao;

import java.util.List;

import br.cefetrj.eic.psw.models.Restaurante;

public interface RestauranteDao {
	public void inserirAtualizar(Restaurante x);
	public void excluir(Restaurante x);
	public Restaurante buscar(Long cod);
	public List<Restaurante> buscarTodos();
	public List<Restaurante> buscarPorNome(String name);
	public List<Restaurante> buscarPorDescricao(String descricao);
	public List<Restaurante> buscarPorCidade(String cidade);
	public List<Restaurante> buscarPorEstado(String estado);


}
