package br.cefetrj.eic.psw.logica;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.cefetrj.eic.psw.models.PontoTuristico;
import br.cefetrj.eic.psw.servico.PontoTuristicoService;
import br.cefetrj.eic.psw.servico.ServicoException;
import br.cefetrj.eic.psw.servico.ServicoFactory;

public class InserePontoTuristicoLogic implements Logica{
	
	private static String INSERIR_OU_ALTERAR = "/ponto_turistico/Inserir.jsp";
	private static String ERRO = "/publico/erro.jsp";
	private static String LISTAR = "/ponto_turistico/Listar.jsp";
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Logger logger = LogManager.getLogger(getClass());
		try {
			logger.info("Inserir Novo Ponto Turístico");
			PontoTuristico alb = new PontoTuristico();
			request.setAttribute("alb", alb);
			return INSERIR_OU_ALTERAR;
		} catch (RuntimeException e) {
			request.setAttribute("erro", "Erro de execução: " + e.getMessage());
			return ERRO;
		}
	}
	
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PontoTuristicoService pontoTuristicoService = ServicoFactory.criarPontoServico();
		String forward = "";
		try {
			PontoTuristico alb = instanciar(request);
			pontoTuristicoService.inserirPonto(alb);
			request.setAttribute("lista", pontoTuristicoService.buscarTodos());
			forward = LISTAR;
		} catch (ServicoException e) {
			request.setAttribute("erro", e.getMessage());
			forward = ERRO;
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}
	private PontoTuristico instanciar(HttpServletRequest req) {
		String aux;
		PontoTuristico x = new PontoTuristico();
		aux = req.getParameter("id");
		if (aux != null && !aux.isEmpty())
			x.setId(Long.parseLong(aux));
		aux = req.getParameter("nome");
		x.setNome(aux);
		aux = req.getParameter("descricao");
		x.setDescricao(aux);
		aux = req.getParameter("cidade");
		x.setCidade(aux);
		aux = req.getParameter("estado");
		x.setEstado(aux);
		
		return x;
	}
	
	
		
}


