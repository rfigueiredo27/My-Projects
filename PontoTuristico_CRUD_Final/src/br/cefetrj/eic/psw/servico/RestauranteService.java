package br.cefetrj.eic.psw.servico;

import java.util.List;

import br.cefetrj.eic.psw.models.Restaurante;

public interface RestauranteService {

	public void inserirRestaurante(Restaurante x) throws ServicoException;
	public void excluir(Restaurante x);
	public Restaurante buscar(Long cod);
	public List<Restaurante> buscarTodos();
	
}
