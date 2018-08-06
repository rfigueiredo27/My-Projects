package br.cefetrj.eic.psw.logica;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.cefetrj.eic.psw.models.Restaurante;
import br.cefetrj.eic.psw.servico.RestauranteService;
import br.cefetrj.eic.psw.servico.ServicoException;
import br.cefetrj.eic.psw.servico.ServicoFactory;

public class InsereRestauranteLogic implements Logica{
	
	private static String ERRO = "/publico/erro.jsp";
	private static String INSERIR_OU_ALTERAR = "/restaurante/Inserir.jsp";
	private static String LISTAR = "/restaurante/Listar.jsp";
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Logger logger = LogManager.getLogger(getClass());
		try {
			logger.info("Inserir Novo Restaurante");
			Restaurante alb = new Restaurante();
			request.setAttribute("alb", alb);
			return INSERIR_OU_ALTERAR;
		} catch (RuntimeException e) {
			request.setAttribute("erro", "Erro de execução: " + e.getMessage());
			return ERRO;
		}
	}
	
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RestauranteService restauranteService = ServicoFactory.criarRestauranteServico();
		String forward = "";
		try {
			Restaurante alb = instanciar(request);
			restauranteService.inserirRestaurante(alb);
			request.setAttribute("lista", restauranteService.buscarTodos());
			forward = LISTAR;
		} catch (ServicoException e) {
			request.setAttribute("erro", e.getMessage());
			forward = ERRO;
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}
	private Restaurante instanciar(HttpServletRequest req) {
		String aux;
		Restaurante x = new Restaurante();
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


