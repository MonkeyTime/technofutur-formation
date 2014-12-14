package be.technofutur.labo.servlets;


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

    public AccessFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		if(request instanceof HttpServletRequest) {
			
			HttpServletRequest req = (HttpServletRequest) request;
			String url = req.getRequestURL().toString();
			
			if(url.contains("/response.do") || url.contains("/create.do")) {
				
				String user = (String) req.getSession().getAttribute("user");
				
				if(user == null) {
					
					req.getRequestDispatcher("/WEB-INF/jsp/redirect-login.jsp").forward(request, response);
				}
				else {

					chain.doFilter(request, response);
				}
			}
			else {

				chain.doFilter(request, response);
			}
		}
		else {

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