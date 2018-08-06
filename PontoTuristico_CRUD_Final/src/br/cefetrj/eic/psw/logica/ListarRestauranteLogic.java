package br.cefetrj.eic.psw.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.cefetrj.eic.psw.servico.RestauranteService;
import br.cefetrj.eic.psw.servico.ServicoFactory;

public class ListarRestauranteLogic implements Logica{
	

	private static String LISTAR = "/restaurante/Listar.jsp";
	private static String ERRO = "/publico/erro.jsp";
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Logger logger = LogManager.getLogger(getClass());
		RestauranteService restauranteService = ServicoFactory.criarRestauranteServico();
		try {
			logger.info("Listar Restaurantes");
			request.setAttribute("lista", restauranteService.buscarTodos());
			return LISTAR;
			
		} catch (RuntimeException e) {
			request.setAttribute("erro", "Erro de execução: " + e.getMessage());
			return ERRO;
		}
	}

}
