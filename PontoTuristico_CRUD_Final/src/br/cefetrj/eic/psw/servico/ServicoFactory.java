package br.cefetrj.eic.psw.servico;

import br.cefetrj.eic.psw.servico.impl.PontoTuristicoServiceImpl;
import br.cefetrj.eic.psw.servico.impl.RestauranteServiceImpl;
import br.cefetrj.eic.psw.servico.impl.UsuarioServiceImpl;

public class ServicoFactory {

	public static PontoTuristicoService criarPontoServico() {
		return new PontoTuristicoServiceImpl();
	}
	
	public static RestauranteService criarRestauranteServico() {
		return new RestauranteServiceImpl();
	}
	
	public static UsuarioService criarUsuarioServico() {
		return new UsuarioServiceImpl();
	}
	
	
}
