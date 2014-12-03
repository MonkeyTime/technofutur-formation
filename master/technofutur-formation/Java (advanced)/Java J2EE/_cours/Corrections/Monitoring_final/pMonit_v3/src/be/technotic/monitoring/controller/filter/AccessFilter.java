package be.technotic.monitoring.controller.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class AccessFilter
 */
public class AccessFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AccessFilter() {
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

		System.out.println("Access Filter");
		if(request instanceof HttpServletRequest) {
			
			HttpServletRequest req = (HttpServletRequest) request;
			String url = req.getRequestURL().toString();
			if(url.endsWith("statistiques.jsp") || url.endsWith("stats") || url.endsWith("stat")) {
				/* implementer ici une méthode d'authentification */
				
				String user = (String) req.getSession().getAttribute("user");
				if(user != null) {
					if(user.equals("admin")) {
						// pass the request along the filter chain
						chain.doFilter(request, response);
					}
				}
				else {
					System.out.println("Filter denied access to stats");
					request.getRequestDispatcher("/jsp/auth.jsp").forward(request, response);
				}
			}
			else {
				// pass the request along the filter chain
				chain.doFilter(request, response);
			}
		}
		else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
