package br.cefetrj.eic.psw.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.cefetrj.eic.psw.logica.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		String parametro = request.getParameter("logica");
		String nomeDaClasse = "br.cefetrj.eic.psw.logica." + parametro;
		Logger logger = LogManager.getLogger();
		try {
			logger.info(parametro+" ");
			Class<?> classe = Class.forName(nomeDaClasse);
			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(request, response);
			request.getRequestDispatcher(pagina).forward(request, response);
		} catch (Exception e) {
			
			logger.error("A lógica "+parametro+" causou uma exceção ", e);
		}
	}
}