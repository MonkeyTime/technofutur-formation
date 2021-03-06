package be.technofutur.labo.servlets;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technofutur.labo.entities.User;

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
				
				User user = (User) req.getSession().getAttribute("user");
				
				if(user == null) {
					
					req.getSession().setAttribute("alertForm", "1");
					
					HttpServletResponse res = (HttpServletResponse) response;
					
					res.sendRedirect("/laboClient/");
				}
				
				chain.doFilter(request, response);
			}
			
			if(url.contains("/endsession.do")) {
				
				req.getSession().setAttribute("user", null);
				
				HttpServletResponse res = (HttpServletResponse) response;
				
				res.sendRedirect("/laboClient/");
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