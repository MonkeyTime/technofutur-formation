package be.technofutur.labo.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technofutur.labo.ejbs.IForumManager;
import be.technofutur.labo.ejbs.ITopicManager;
import be.technofutur.labo.entities.Forum;
import be.technofutur.labo.entities.Topic;

public class ForumServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB() 
	IForumManager forumManager;
	@EJB()
	ITopicManager topicManager;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Forum forum = forumManager.findById(Integer.parseInt(request.getParameter("id")));
		System.out.println(forum.toString());
		
		List<Topic> topics = topicManager.findByForumId(forum.getId());
		
		request.getSession().setAttribute("title", forum.getName());
		request.getSession().setAttribute("description", forum.getDescription());
		request.getSession().setAttribute("forum", forum);
		request.getSession().setAttribute("topics", topics);
		
		request.getRequestDispatcher("/WEB-INF/jsp/forum.jsp").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
