package br.cefetrj.eic.psw.logica;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.cefetrj.eic.psw.models.Restaurante;
import br.cefetrj.eic.psw.servico.RestauranteService;
import br.cefetrj.eic.psw.servico.ServicoFactory;

public class DetalheRestauranteLogic implements Logica{

	private static String INSERIR_OU_ALTERAR = "/restaurante/Detalhes.jsp";
	private static String LISTAR = "/restaurante/Listar.jsp";
	private static String ERRO = "/publico/erro.jsp";
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Logger logger = LogManager.getLogger(getClass());
		RestauranteService restauranteService = ServicoFactory.criarRestauranteServico();
		
		Long id = Long.parseLong(request.getParameter("id"));
		try {
			logger.info("Detalhes Restaurante - ID: " + request.getParameter("id"));
			Restaurante alb = restauranteService.buscar(id);
			if (alb != null) {
				request.setAttribute("alb", alb);
				return INSERIR_OU_ALTERAR;
			}
			else {
				request.setAttribute("lista", restauranteService.buscarTodos());
				return LISTAR;
			}
		} catch (RuntimeException e) {
			request.setAttribute("Erro de execu��o: ", e.getMessage());
			return ERRO;
		}

}
}
