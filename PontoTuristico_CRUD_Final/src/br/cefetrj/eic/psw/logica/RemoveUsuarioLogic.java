package br.cefetrj.eic.psw.logica;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.cefetrj.eic.psw.models.Usuario;
import br.cefetrj.eic.psw.servico.ServicoFactory;
import br.cefetrj.eic.psw.servico.UsuarioService;


public class RemoveUsuarioLogic implements Logica{

	private static String LISTAR = "/usuario/Listar.jsp";
	private static String ERRO = "/publico/erro.jsp";
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Logger logger = LogManager.getLogger(getClass());
		UsuarioService usuService = ServicoFactory.criarUsuarioServico();
		Long id = Long.parseLong(request.getParameter("id"));
		try {
			Usuario alb = usuService.buscar(id);
			if (alb != null) {
				usuService.excluir(alb);
				
			}
			logger.info("Removeu Usuário - ID: " + request.getParameter("id"));
			request.setAttribute("lista", usuService.buscarTodos());
			return LISTAR;
		} catch (RuntimeException e) {
			request.setAttribute("erro", "Erro de execução: " + e.getMessage());
			return ERRO;
		}

	}

}
