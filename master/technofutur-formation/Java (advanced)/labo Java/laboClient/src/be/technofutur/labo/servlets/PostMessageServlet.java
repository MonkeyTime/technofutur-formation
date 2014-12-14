package be.technofutur.labo.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technofutur.labo.ejbs.ITopicManager;
import be.technofutur.labo.entities.Topic;

/**
 * Servlet implementation class CreateTopicServlet
 */

public class PostMessageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	@EJB()
	ITopicManager topicManager;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Topic topic = topicManager.findById(Integer.parseInt(request.getParameter("subject")));
		
		request.getSession().setAttribute("title", "Response");
		request.getSession().setAttribute("description", "Response to " + topic.getTitle());
		request.getSession().setAttribute("topic", topic);
		
		request.getRequestDispatcher("/WEB-INF/jsp/messageForm.jsp").include(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//@TODO Create and register response based on POST and with its manager
	}

}
