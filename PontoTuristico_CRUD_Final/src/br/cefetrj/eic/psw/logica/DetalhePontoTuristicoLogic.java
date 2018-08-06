package br.cefetrj.eic.psw.logica;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.cefetrj.eic.psw.models.PontoTuristico;
import br.cefetrj.eic.psw.servico.PontoTuristicoService;
import br.cefetrj.eic.psw.servico.ServicoFactory;

public class DetalhePontoTuristicoLogic implements Logica{

	private static String INSERIR_OU_ALTERAR = "/ponto_turistico/Detalhes.jsp";
	private static String LISTAR = "/ponto_turistico/Listar.jsp";
	private static String ERRO = "/publico/erro.jsp";
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Logger logger = LogManager.getLogger(getClass());
		PontoTuristicoService pontoTuristicoService = ServicoFactory.criarPontoServico();
		
		Long id = Long.parseLong(request.getParameter("id"));
		try {
			logger.info("Detalhes Ponto Turístico - ID: " + request.getParameter("id"));
			PontoTuristico alb = pontoTuristicoService.buscar(id);
			if (alb != null) {
				request.setAttribute("alb", alb);
				return INSERIR_OU_ALTERAR;
			}
			else {
				request.setAttribute("lista", pontoTuristicoService.buscarTodos());
				return LISTAR;
			}
		} catch (RuntimeException e) {
			request.setAttribute("Erro de execuï¿½ï¿½o: ", e.getMessage());
			return ERRO;
		}

}
}
