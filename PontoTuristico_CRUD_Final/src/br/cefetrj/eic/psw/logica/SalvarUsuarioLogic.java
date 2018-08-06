package br.cefetrj.eic.psw.logica;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.cefetrj.eic.psw.models.Usuario;
import br.cefetrj.eic.psw.servico.ServicoException;
import br.cefetrj.eic.psw.servico.ServicoFactory;
import br.cefetrj.eic.psw.servico.UsuarioService;

public class SalvarUsuarioLogic implements Logica{
	
	private static String LISTAR = "/usuario/Listar.jsp";
	private static String ERRO = "/publico/erro.jsp";
	

	public String executa(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Logger logger = LogManager.getLogger(getClass());
		UsuarioService usuService = ServicoFactory.criarUsuarioServico();
		
		try {
			Usuario alb = instanciar(request);
			usuService.inserirUsuario(alb);
			if(request.getParameter("id")!=""){
				logger.info("Alterou Usuario - ID: " + request.getParameter("id"));
				}
				else{
					logger.info("Salvou novo Usuário");
				}
			request.setAttribute("lista", usuService.buscarTodos());
			return LISTAR;
		} catch (ServicoException e) {
			request.setAttribute("erro", e.getMessage());
			return ERRO;
		}
	}
	public Usuario instanciar(HttpServletRequest req) {
		String aux;
		Usuario x = new Usuario();
		
		aux = req.getParameter("id");
		if (aux != null && !aux.isEmpty())
			x.setId(Long.parseLong(aux));
		
		aux = req.getParameter("nome");
		x.setNome(aux);
		
		aux = req.getParameter("login");
		x.setLogin(aux);
		
		aux = req.getParameter("senha");
		x.setSenha(aux);
		
		return x;
	}
	
	
	}


