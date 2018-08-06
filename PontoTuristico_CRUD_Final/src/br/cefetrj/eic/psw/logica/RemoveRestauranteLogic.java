package br.cefetrj.eic.psw.logica;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.cefetrj.eic.psw.models.Restaurante;
import br.cefetrj.eic.psw.servico.RestauranteService;
import br.cefetrj.eic.psw.servico.ServicoFactory;


public class RemoveRestauranteLogic implements Logica{

	private static String LISTAR = "/restaurante/Listar.jsp";
	private static String ERRO = "/publico/erro.jsp";
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Logger logger = LogManager.getLogger(getClass());
		RestauranteService restauranteService = ServicoFactory.criarRestauranteServico();
		Long id = Long.parseLong(request.getParameter("id"));
		try {
			Restaurante alb = restauranteService.buscar(id);
			if (alb != null) {
				restauranteService.excluir(alb);
				
			}
			logger.info("Removeu Restaurante - ID: " + request.getParameter("id"));
			request.setAttribute("lista", restauranteService.buscarTodos());
			return LISTAR;
		} catch (RuntimeException e) {
			request.setAttribute("erro", "Erro de execução: " + e.getMessage());
			return ERRO;
		}

	}

}
