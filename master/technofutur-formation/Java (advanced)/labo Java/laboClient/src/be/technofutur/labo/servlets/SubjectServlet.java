package be.technofutur.labo.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technofutur.labo.ejbs.IForumManager;
import be.technofutur.labo.ejbs.IPostManager;
import be.technofutur.labo.ejbs.ITopicManager;
import be.technofutur.labo.entities.Forum;
import be.technofutur.labo.entities.Post;
import be.technofutur.labo.entities.Topic;

public class SubjectServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB()
	IForumManager forumManager;
	@EJB()
	ITopicManager topicManager;
	@EJB() 
	IPostManager postManager;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().setAttribute("hellotxt", "Hello");
		
		Forum forum = forumManager.findById(Integer.parseInt(request.getParameter("forum")));
		Topic topic = topicManager.findById(Integer.parseInt(request.getParameter("id")));
		List<Post> posts = postManager.findByTopicId(topic.getId());
		
		request.getSession().setAttribute("title", topic.getTitle());
		request.getSession().setAttribute("description", topic.getTitle() + " - " + topic.getCreatedBy());
		request.getSession().setAttribute("topic", topic);
		request.getSession().setAttribute("posts", posts);
		request.getSession().setAttribute("forum", forum);
		request.getSession().setAttribute("category", forum.getCategory().getName());
		
		request.getRequestDispatcher("/WEB-INF/jsp/subject.jsp").include(request, response);
		
		request.getSession().setAttribute("topic", null);
		request.getSession().setAttribute("posts", null);
		request.getSession().setAttribute("forum", null);
		request.getSession().setAttribute("category", null);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
