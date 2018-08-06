package br.cefetrj.eic.psw.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet Filter implementation class Filter
 */
@WebFilter("/*")
public class FilterTempoExecucao implements Filter {

    /**
     * Default constructor. 
     */
    public FilterTempoExecucao() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see FilterTempoExecucao#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see FilterTempoExecucao#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Logger logger = LogManager.getLogger(getClass());
		long tempoInicial = System.currentTimeMillis();
		chain.doFilter(request, response);
		long tempoFinal = System.currentTimeMillis();
		String uri = ((HttpServletRequest)request).getRequestURI();
		String parametros = ((HttpServletRequest) request)
		.getParameter("logica");
		logger.info("Tempo da requisicao de " + uri
		+ "?logica="
		+ parametros + " demorou (ms): "
		+ (tempoFinal - tempoInicial));
	}

	/**
	 * @see FilterTempoExecucao#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
