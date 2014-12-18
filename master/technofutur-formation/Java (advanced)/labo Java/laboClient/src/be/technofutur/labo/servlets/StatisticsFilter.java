package be.technofutur.labo.servlets;


import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import be.technofutur.labo.ejbs.IPostManager;
import be.technofutur.labo.ejbs.ITopicManager;
import be.technofutur.labo.entities.Topic;

/**
 * Servlet Filter implementation class AccessFilter
 */
public class StatisticsFilter implements Filter {

    public StatisticsFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	@EJB()
	ITopicManager topicManager;
	@EJB() 
	IPostManager postManager;
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		if(request instanceof HttpServletRequest) {
			
			HttpServletRequest req = (HttpServletRequest) request;
			String url = req.getRequestURL().toString();
			
			if(url.contains("/subject.do")) {
				
				//statistics
				
				int id = Integer.parseInt(request.getParameter("id"));
				
				Topic topic = topicManager.findById(id);
				topic.setTotalViews(topic.getTotalViews() + 1);
				
				topicManager.save(topic);
			}
		}

		chain.doFilter(request, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}