package br.cefetrj.eic.psw.logica;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.cefetrj.eic.psw.models.PontoTuristico;
import br.cefetrj.eic.psw.servico.PontoTuristicoService;
import br.cefetrj.eic.psw.servico.ServicoFactory;


public class RemovePontoTuristicoLogic implements Logica{

	private static String LISTAR = "/ponto_turistico/Listar.jsp";
	private static String ERRO = "/publico/erro.jsp";
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Logger logger = LogManager.getLogger(getClass());
		PontoTuristicoService pontoTuristicoService = ServicoFactory.criarPontoServico();
		Long id = Long.parseLong(request.getParameter("id"));
		try {
			PontoTuristico alb = pontoTuristicoService.buscar(id);
			if (alb != null) {
				pontoTuristicoService.excluir(alb);
				logger.info("Removeu Ponto Turístico - ID: " + request.getParameter("id"));
			}
			request.setAttribute("lista", pontoTuristicoService.buscarTodos());
			return LISTAR;
		} catch (RuntimeException e) {
			request.setAttribute("erro", "Erro de execução: " + e.getMessage());
			return ERRO;
		}

	}

}
