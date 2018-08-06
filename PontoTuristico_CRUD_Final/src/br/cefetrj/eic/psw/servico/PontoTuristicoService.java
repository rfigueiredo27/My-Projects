package br.cefetrj.eic.psw.servico;

import java.util.List;

import br.cefetrj.eic.psw.models.PontoTuristico;

public interface PontoTuristicoService {

	public void inserirPonto(PontoTuristico x) throws ServicoException;
	public void excluir(PontoTuristico x);
	public PontoTuristico buscar(Long cod);
	public List<PontoTuristico> buscarTodos();
	public List<PontoTuristico> buscarPorNome(String trechoNome);
}
