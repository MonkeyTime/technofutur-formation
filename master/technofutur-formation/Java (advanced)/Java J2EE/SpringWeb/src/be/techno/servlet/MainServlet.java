package be.techno.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import be.techno.servlet.manager.PersonneManager;

public class MainServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -704625969545932945L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, res);
		
		req.getSession().setAttribute("message", "");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String nom = req.getParameter("personne");
		
		if(nom != null && nom != "") {
			
			BeanFactory factory = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
			PersonneManager manager = factory.getBean("personneManager", PersonneManager.class);
		
			manager.createPersonne(nom);
			
			req.getSession().setAttribute("message", "Your user " + nom + " was created. Thx you.");
			
			doGet(req, res);
			
		} else {
			
			req.getSession().setAttribute("message", "User must be a valid user and can not be empty.");
			
			doGet(req, res);
		}
	}

}
