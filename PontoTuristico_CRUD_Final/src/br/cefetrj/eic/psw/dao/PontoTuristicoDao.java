package br.cefetrj.eic.psw.dao;

import java.util.List;

import br.cefetrj.eic.psw.models.PontoTuristico;

public interface PontoTuristicoDao {
	public void inserirAtualizar(PontoTuristico x);
	public void excluir(PontoTuristico x);
	public PontoTuristico buscar(Long cod);
	public List<PontoTuristico> buscarTodos();
	public List<PontoTuristico> buscarPorNome(String name);
	public List<PontoTuristico> buscarPorDescricao(String descricao);
	public List<PontoTuristico> buscarPorCidade(String cidade);
	public List<PontoTuristico> buscarPorEstado(String estado);
	


}
