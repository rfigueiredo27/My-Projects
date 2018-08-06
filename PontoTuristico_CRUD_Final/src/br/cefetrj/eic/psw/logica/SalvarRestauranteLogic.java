package br.cefetrj.eic.psw.logica;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.cefetrj.eic.psw.models.Restaurante;
import br.cefetrj.eic.psw.servico.RestauranteService;
import br.cefetrj.eic.psw.servico.ServicoException;
import br.cefetrj.eic.psw.servico.ServicoFactory;

public class SalvarRestauranteLogic implements Logica{
	
	private static String LISTAR = "/restaurante/Listar.jsp";
	private static String ERRO = "/publico/erro.jsp";
	

	public String executa(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Logger logger = LogManager.getLogger(getClass());
		RestauranteService restauranteService = ServicoFactory.criarRestauranteServico();
		
		try {
			Restaurante alb = instanciar(request);
			restauranteService.inserirRestaurante(alb);
			if(request.getParameter("id")!=""){
				logger.info("Alterou Restaurante - ID: " + request.getParameter("id"));
				}
				else{
					logger.info("Salvou novo Restaurante");
				}
			request.setAttribute("lista", restauranteService.buscarTodos());
			return LISTAR;
		} catch (ServicoException e) {
			request.setAttribute("erro", e.getMessage());
			return ERRO;
		}
	}
	
	public Restaurante instanciar(HttpServletRequest req) {
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


