package be.technofutur.labo.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technofutur.labo.ejbs.IForumManager;
import be.technofutur.labo.entities.Forum;

/**
 * Servlet implementation class CreateTopicServlet
 */
public class CreateTopicServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
	@EJB() 
	IForumManager forumManager;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Forum forum = forumManager.findById(Integer.parseInt(request.getParameter("forum")));
		request.getSession().setAttribute("title", "Create topic");
		request.getSession().setAttribute("description", "Start a new topic in forum " + forum.getName());
		request.getSession().setAttribute("forum", forum);
		
		request.getRequestDispatcher("/WEB-INF/jsp/topicForm.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//@TODO Create and register topic based on POST and with its manager
	}

}
