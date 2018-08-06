package br.cefetrj.eic.psw.logica;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import br.cefetrj.eic.psw.dao.jpa.PontoTuristicoDaoImpl;


public class ListarPontoTuristicoLogic implements Logica{
	

	private static String LISTAR = "/ponto_turistico/Listar.jsp";
	private static String ERRO = "/publico/erro.jsp";
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Logger logger = LogManager.getLogger(getClass());
		
		logger.info("Listar Ponto Turistico");
		
		EntityManager em = (EntityManager) request.getAttribute("em");
		PontoTuristicoDaoImpl dao = new PontoTuristicoDaoImpl(em);
		//PontoTuristicoService pontoTuristicoService = ServicoFactory.criarPontoServico(em);
		try {
			request.setAttribute("lista", dao.buscarTodos());
			return LISTAR;
		} catch (RuntimeException e) {
			request.setAttribute("erro", "Erro de execução: " + e.getMessage() );
			return ERRO;
		}
	}

}
