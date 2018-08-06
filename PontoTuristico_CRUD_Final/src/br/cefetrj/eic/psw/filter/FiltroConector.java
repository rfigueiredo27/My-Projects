package br.cefetrj.eic.psw.filter;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.logging.log4j.LogManager;
import br.cefetrj.eic.psw.connection.EMF;
import org.apache.logging.log4j.Logger;
/**
 * Servlet Filter implementation class FiltroConector
 */
@WebFilter("/*")
public class FiltroConector implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroConector() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		Logger logger = LogManager.getLogger();
		
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		EntityManager em = null;
		try {
			
			new EMF();
			em = EMF.getConector();
			request.setAttribute("em", em);
			chain.doFilter(request, response);
		}catch (Exception e) {
			logger.error(e.getMessage() + request.getParameter("erro"));
		}finally{
			try{
				if(em != null){
					em.close();
				}
			}catch (Exception e2){
				e2.printStackTrace();
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
