package br.cefetrj.eic.psw.logica;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.cefetrj.eic.psw.models.PontoTuristico;
import br.cefetrj.eic.psw.servico.PontoTuristicoService;
import br.cefetrj.eic.psw.servico.ServicoException;
import br.cefetrj.eic.psw.servico.ServicoFactory;

public class SalvarPontoTuristicoLogic implements Logica{
	
	private static String LISTAR = "/ponto_turistico/Listar.jsp";
	private static String ERRO = "/publico/erro.jsp";
	

	public String executa(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Logger logger = LogManager.getLogger(getClass());
		PontoTuristicoService pontoTuristicoService = ServicoFactory.criarPontoServico();
		
		try {
			PontoTuristico alb = instanciar(request);
			pontoTuristicoService.inserirPonto(alb);
			if(request.getParameter("id")!=""){
			logger.info("Alterou Ponto Turístico - ID: " + request.getParameter("id"));
			}
			else{
				logger.info("Salvou novo ponto Turístico");
			}
			request.setAttribute("lista", pontoTuristicoService.buscarTodos());
			return LISTAR;
		} catch (ServicoException e) {
			request.setAttribute("erro", e.getMessage());
			return ERRO;
		}
	}
	public PontoTuristico instanciar(HttpServletRequest req) {
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


