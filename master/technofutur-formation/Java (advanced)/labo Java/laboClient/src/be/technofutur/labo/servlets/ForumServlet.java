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
import be.technofutur.labo.entities.User;

public class ForumServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB()
	ITopicManager topicManager;
	@EJB() 
	IForumManager forumManager;
	@EJB()
	IPostManager postManager;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().setAttribute("hellotxt", "Hello");
		
		if(request.getParameter("action") != null && request.getParameter("action").equals("delete")) {
			
			User usr = (User) request.getSession().getAttribute("user");
			
			if(usr != null && usr.getRole().getId() == 1) {

				List<Post> posts = postManager.findByTopicId(Integer.parseInt(request.getParameter("subject")));
				Topic topic = topicManager.findById(Integer.parseInt(request.getParameter("subject")));
				Forum forum = topic.getForum();
				
				if(posts.size() > 0) {
					for(Post post : posts) {
						postManager.delete(post);
						forum.setTotalPosts(forum.getTotalPosts() - 1);
					}
				}
				
				topic.setForum(null);
				forum.getTopics().remove(topic);
				
				topicManager.delete(topic);
				
				forum.setTotalTopics(forum.getTotalTopics() - 1);
				
				forumManager.save(forum);
				
				request.getSession().setAttribute("messageOk", "The topic was deleted. Thx you.");
				request.getSession().setAttribute("forum", forum);
				
				response.sendRedirect("/laboClient/forum.do?id=" + forum.getId());
				
			} else {
				
				request.getSession().setAttribute("message", "You can't delete this topic. Only admin can delete a topic.");
				
				response.sendRedirect("/laboClient/forum.do?id=" + request.getParameter("forum"));
			}

			
		} else if(request.getParameter("action") != null && request.getParameter("action").equals("edit")) {
			
			User usr = (User) request.getSession().getAttribute("user");
			Topic topic = topicManager.findById(Integer.parseInt(request.getParameter("subject")));
			
			if(usr != null && (usr.getRole().getId() == 1 || topic.getCreatedBy().equals(usr.getUsername()))) {

				request.getSession().setAttribute("title", "Edit topic");
				request.getSession().setAttribute("description", "Edit the topic");
				
				request.getSession().setAttribute("topic", topic);
				request.getSession().setAttribute("forum", topic.getForum());
				
				List<Post> posts = postManager.findByTopicId(topic.getId());
				Post post = posts.get(0);
				request.getSession().setAttribute("post", post);
				request.getSession().setAttribute("topic", topic);
				request.getSession().setAttribute("action", "edit");
				request.getSession().setAttribute("category", topic.getForum().getCategory().getName());
				
				request.getRequestDispatcher("/WEB-INF/jsp/topicForm.jsp").include(request, response);
				
				request.getSession().setAttribute("messageOk", null);
				request.getSession().setAttribute("message", null);
				request.getSession().setAttribute("post", null);
				request.getSession().setAttribute("topic", null);
				request.getSession().setAttribute("category", null);
				
			} else {
				
				request.getSession().setAttribute("message", "You can't edit this topic. Only admin or original author can edit this topic.");
				
				response.sendRedirect("/laboClient/forum.do?id=" + request.getParameter("forum"));
			}
			
		} else {
		
			Forum forum = forumManager.findById(Integer.parseInt(request.getParameter("id")));
			request.getSession().setAttribute("title", forum.getName());
			request.getSession().setAttribute("description", forum.getDescription());
			request.getSession().setAttribute("forum", forum);
			request.getSession().setAttribute("topics", forum.getTopics());
			request.getSession().setAttribute("category", forum.getCategory().getName());
			
			request.getRequestDispatcher("/WEB-INF/jsp/forum.jsp").include(request, response);
			
			request.getSession().setAttribute("forum", null);
			request.getSession().setAttribute("topics", null);
			request.getSession().setAttribute("category", null);
			request.getSession().setAttribute("message", null);
			request.getSession().setAttribute("messageOk", null);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
