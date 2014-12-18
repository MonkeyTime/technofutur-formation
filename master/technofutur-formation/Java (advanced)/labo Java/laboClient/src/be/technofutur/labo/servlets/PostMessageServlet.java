package be.technofutur.labo.servlets;

import java.io.IOException;
import java.sql.Date;

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
import be.technofutur.labo.entities.User;

/**
 * Servlet implementation class CreateTopicServlet
 */

public class PostMessageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@EJB()
	IForumManager forumManager;
	@EJB()
	ITopicManager topicManager;
	@EJB() 
	IPostManager postManager;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().setAttribute("hellotxt", "Hello");
		
		Topic topic = topicManager.findById(Integer.parseInt(request.getParameter("subject")));
		
		request.getSession().setAttribute("title", "Response");
		request.getSession().setAttribute("description", "Response to " + topic.getTitle());
		request.getSession().setAttribute("topic", topic);
		
		request.getRequestDispatcher("/WEB-INF/jsp/messageForm.jsp").include(request, response);
		
		request.getSession().setAttribute("topic", null);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().setAttribute("hellotxt", "Hello");
		
		User usr = (User) request.getSession().getAttribute("user");
		
		if(usr != null) {
			
			int id = Integer.parseInt(request.getParameter("topicId"));
			
			//statistics topic updated
			Topic topic = topicManager.findById(id);
			topic.setLastPostBy(usr.getUsername());
			topic.setLastPostTime(new Date(System.currentTimeMillis()));
			topic.setTotalReplies(topic.getTotalReplies() + 1);
			
			topicManager.save(topic);
			
			//post to the db the response for one particular topic
			Post post = new Post();
			post.setCreationTime(new Date(System.currentTimeMillis()));
			post.setTitle(null);
			post.setMessage(request.getParameter("message"));
			post.setTopic(topic);
			post.setUser(usr);
			post.setUserName(usr.getUsername());
			
			postManager.create(post);
			
			Forum forum = forumManager.findById(topic.getForum().getId());
			forum.setTotalPosts(forum.getTotalPosts() + 1);
			
			forumManager.save(forum);
			
			request.getSession().setAttribute("messageOk", "Thx you, your message was submited to the subject <a href=\"/laboClient/subject.do?id="+ topic.getId() + "&forum=" + topic.getForum().getId() +"\">" + topic.getTitle() + "</a>");
			
			request.getRequestDispatcher("/WEB-INF/jsp/messageForm.jsp").include(request, response);
		}
	}
}
