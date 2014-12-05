package be.techno.servlet;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import be.techno.servlet.manager.PersonneManager;

public class ListUserServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2794495435311219689L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		BeanFactory factory = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
		PersonneManager manager = factory.getBean("personneManager", PersonneManager.class);
	
		List<Personne> items = manager.getList();
		
		req.setAttribute("items", items);
		
		@SuppressWarnings("unused")
		String message = req.getSession().getAttribute("message") != null ? req.getSession().getAttribute("message").toString() : null;
		
		req.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req, res);
	}
}
