package be.techno.servlet;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import be.techno.servlet.manager.PersonneManager;

public class ManageUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4246094354300858812L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		
		if(action == "delete") {
			
			BeanFactory factory = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
			
			PersonneManager manager = factory.getBean("personneManager", PersonneManager.class);
	
			manager.deletePersonne(Integer.valueOf(req.getParameter("id")));
		
			req.getSession().setAttribute("message", "Thx you. The user " + req.getParameter("id") + " was correctly deleted.");
		
			res.sendRedirect("list.do");
			
		} else if(action == "edit") {
			
			BeanFactory factory = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
			
			PersonneManager manager = factory.getBean("personneManager", PersonneManager.class);
	
			Personne personne = manager.getPersonneById(Integer.valueOf(req.getParameter("id")));
			
			req.getSession().setAttribute("item", personne);
			
			req.getRequestDispatcher("/WEB-INF/jsp/edit.jsp").forward(req, res);
			
		} else if(action == "update") {
		
			BeanFactory factory = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
			
			PersonneManager manager = factory.getBean("personneManager", PersonneManager.class);
	
			manager.updatePersonne(Integer.valueOf(req.getParameter("id")));
		
			req.getSession().setAttribute("message", "Thx you. The user " + req.getParameter("id") + " was correctly updated.");
		
			res.sendRedirect("list.do");
			
		}
		else {
			
			res.sendRedirect("list.do");
		}
	}
}