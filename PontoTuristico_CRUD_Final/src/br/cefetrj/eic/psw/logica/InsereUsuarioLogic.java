package br.cefetrj.eic.psw.logica;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.cefetrj.eic.psw.models.Usuario;

public class InsereUsuarioLogic implements Logica{
	
	private static String INSERIR_OU_ALTERAR = "/usuario/Inserir.jsp";
	private static String ERRO = "/publico/erro.jsp";
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Logger logger = LogManager.getLogger(getClass());
		try {
			logger.info("Inserir Novo Usuario");
			Usuario alb = new Usuario();
			request.setAttribute("alb", alb);
			return INSERIR_OU_ALTERAR;
		} catch (RuntimeException e) {
			request.setAttribute("erro", "Erro de execução: " + e.getMessage());
			return ERRO;
		}
	}
	
}


