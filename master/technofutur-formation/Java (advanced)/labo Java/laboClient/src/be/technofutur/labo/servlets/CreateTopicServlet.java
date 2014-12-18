package be.technofutur.labo.servlets;

import java.io.IOException;
import java.sql.Date;
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
import be.technofutur.labo.entities.User;

/**
 * Servlet implementation class CreateTopicServlet
 */
public class CreateTopicServlet extends HttpServlet {
	
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
		request.getSession().setAttribute("title", "Create topic");
		request.getSession().setAttribute("description", "Start a new topic in forum " + forum.getName());
		request.getSession().setAttribute("forum", forum);
		request.getSession().setAttribute("category", forum.getCategory().getName());
		
		request.getRequestDispatcher("/WEB-INF/jsp/topicForm.jsp").include(request, response);
		
		request.getSession().setAttribute("messageOk", null);
		request.getSession().setAttribute("forum", null);
		request.getSession().setAttribute("category", null);
		request.getSession().setAttribute("action", null);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.getSession().setAttribute("hellotxt", "Hello");
		
		User usr = (User) request.getSession().getAttribute("user");
		
		if(usr != null) {
			
			if(request.getParameter("action") != null && request.getParameter("action").equals("edit")) {
				
				Topic topic = topicManager.findById(Integer.parseInt(request.getParameter("id")));
				topic.setTitle(request.getParameter("title"));
				topicManager.save(topic);
				
				List<Post> posts = postManager.findByTopicId(Integer.parseInt(request.getParameter("id")));
				Post post = posts.get(0);
				post.setMessage(request.getParameter("message"));
				post.setTopic(topic);
				
				postManager.save(post);
				
				request.getSession().setAttribute("messageOk", "Thx you, your topic was updated to the forum. Your url is <a href=\"/laboClient/subject.do?id="+ topic.getId() + "&forum=" + topic.getForum().getId() +"\">" + topic.getTitle() + "</a>");
				
				request.getRequestDispatcher("/WEB-INF/jsp/topicForm.jsp").include(request, response);
				
				request.getSession().setAttribute("messageOk", null);
				request.getSession().setAttribute("action", null);
				
			} else {
				
				Topic topic = new Topic();
				topic.setCreatedBy(usr.getUsername());
				topic.setLastPostBy(usr.getUsername());
				topic.setLastPostTime(new Date(System.currentTimeMillis()));
				topic.setTotalReplies(1);
				Forum forum = forumManager.findById(Integer.parseInt(request.getParameter("forumId")));
				topic.setForum(forum);
				topic.setCreationTime(new Date(System.currentTimeMillis()));
				topic.setTitle(request.getParameter("title"));
				topic.setTotalViews(0);
				
				topicManager.create(topic);
				
				Post post = new Post();
				
				post.setCreationTime(new Date(System.currentTimeMillis()));
				post.setTitle(null);
				post.setMessage(request.getParameter("message"));
				post.setTopic(topic);
				post.setUserName(usr.getUsername());
				post.setUser(usr);
				
				postManager.create(post);
				
				forum.setTotalTopics(forum.getTotalTopics() + 1);
				forum.setTotalPosts(forum.getTotalPosts() + 1);
				
				forumManager.save(forum);
				
				request.getSession().setAttribute("messageOk", "Thx you, your topic was submited to the forum. Your url is <a href=\"/laboClient/subject.do?id="+ topic.getId() + "&forum=" + topic.getForum().getId() +"\">" + topic.getTitle() + "</a>");
				
				request.getRequestDispatcher("/WEB-INF/jsp/topicForm.jsp").include(request, response);
				
				request.getSession().setAttribute("messageOk", null);
			}
		}
	}

}
