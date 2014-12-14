package be.technofutur.labo.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technofutur.labo.ejbs.ICategoryManager;
import be.technofutur.labo.ejbs.IForumManager;
import be.technofutur.labo.entities.Category;
import be.technofutur.labo.entities.Forum;

public class IndexServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB() 
	ICategoryManager categoryManager;
	@EJB() 
	IForumManager forumManager;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Forum> forums = forumManager.findAll();
		List<Category> categories = categoryManager.findAll();
		
		request.getSession().setAttribute("title", "Home");
		request.getSession().setAttribute("description", "Forums list");
		request.getSession().setAttribute("forums", forums);
		request.getSession().setAttribute("categories", categories);
		request.getSession().setAttribute("message", null);
		
		if(request.getParameter("s") != null && 1 == Integer.parseInt(request.getParameter("s"))) {
			request.getSession().setAttribute("message", "You must login or register before to continue.");
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").include(request, response);
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//@TODO create user login or user register
		
		//@TODO finish with doGet and set a session message (you are loggedin now thx)
		doGet(request, response);
	}
}
