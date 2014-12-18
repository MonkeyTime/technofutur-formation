package be.technofutur.labo.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technofutur.labo.ejbs.ICategoryManager;
import be.technofutur.labo.ejbs.IForumManager;
import be.technofutur.labo.ejbs.IRoleManager;
import be.technofutur.labo.ejbs.IUserManager;
import be.technofutur.labo.entities.Category;
import be.technofutur.labo.entities.Forum;
import be.technofutur.labo.entities.User;

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
		
		request.getSession().setAttribute("hellotxt", "Hello");
		
		List<Forum> forums = forumManager.findAll();
		List<Category> categories = categoryManager.findAll();
		
		request.getSession().setAttribute("title", "Home");
		request.getSession().setAttribute("description", "Forums list");
		request.getSession().setAttribute("forums", forums);
		request.getSession().setAttribute("categories", categories);
		
		if(request.getSession().getAttribute("alertForm") != null) {
			request.getSession().setAttribute("message", "You must login or register before to post.");
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").include(request, response);
			
		request.getSession().setAttribute("message", null);
		request.getSession().setAttribute("messageOk", null);
		request.getSession().setAttribute("alertForm", null);
	}

	@EJB()
	IUserManager userManager;
	@EJB()
	IRoleManager roleManager;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().setAttribute("hellotxt", "Hello");
		
		if(request.getParameter("login") != null) {
			
			if(request.getParameter("username") != "" 
			&& request.getParameter("password") != "") {
			
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				
				User user = userManager.findByUsername(request.getParameter("username"));
	
				if(user != null && user.getUsername().equals(username) && user.getPassword().equals(password)) {
	
					user.setLastVisitDate(new Date(System.currentTimeMillis()));
					userManager.save(user);
					
					request.getSession().setAttribute("user", user);
					request.getSession().setAttribute("role", user.getRole().getId());
					request.getSession().setAttribute("categories", categoryManager.findAll());
					
					request.getSession().setAttribute("messageOk", "You are now logged in. Thx.");
					
					doGet(request, response);
					
				} else {
					
					request.getSession().setAttribute("message", "Username and password did not match or password is empty.");
					
					doGet(request, response);
				}
			}	
			
		} else if(request.getParameter("register") != null) { 
				
			if(request.getParameter("password1") != "" 
			&& request.getParameter("password2") != "" 
			&& request.getParameter("username") != ""
			&& request.getParameter("password1").equals(request.getParameter("password2"))) {
			
				
				String username = request.getParameter("username");
				String password = request.getParameter("password1");
				String email = request.getParameter("email");
				String firstName = request.getParameter("firstname") != "" ? request.getParameter("firstname")  : null;
				String lastName = request.getParameter("lastname") != "" ? request.getParameter("lastname")  : null;
				//int roleId = request.getParameter("roleId") != null ? Integer.parseInt(request.getParameter("roleId")) : 2;
			
				
				User user = userManager.findByUsername(username);
				
				if(user == null || !user.getUsername().equals(username)) {
					
					User usr = new User();
					usr.setEmail(email);
					usr.setFirstName(firstName);
					usr.setLastName(lastName);
					usr.setUsername(username);
					usr.setPassword(password);
					usr.setRole(roleManager.findById(2));
					usr.setRegistrationDate(new Date(System.currentTimeMillis()));
					usr.setLastVisitDate(new Date(System.currentTimeMillis()));
					usr.setTotalPost(0);
					userManager.create(usr);
					
					request.getSession().setAttribute("messageOk", "Please validate your account. An email was send. Thx.");
					
					doGet(request, response);
					
				} else {
					
					request.getSession().setAttribute("message", "This username is already in use, please choose another username.");
					
					doGet(request, response);
				}
				
			} else {
				
				request.getSession().setAttribute("message", "Mendatory: username, email and the two password must match.");
				
				doGet(request, response);
			}
		}
		else if(request.getParameter("action") != null && request.getParameter("action").equals("container")) {
			
			User user = (User) request.getSession().getAttribute("user");
			
			if(user != null && user.getRole().getId()  == 1) {
				
				Category category = new Category();
				category.setName(request.getParameter("container-name"));
				
				categoryManager.create(category);
				
				request.getSession().setAttribute("messageOk", "You have created the new category. Thx.");
				
				doGet(request, response);
				
			}
		}
		else if(request.getParameter("action") != null && request.getParameter("action").equals("forum")) {
			
			User user = (User) request.getSession().getAttribute("user");
			
			if(user != null && user.getRole().getId()  == 1) {
				
				Forum forum = new Forum();
				forum.setName(request.getParameter("title"));
				forum.setDescription(request.getParameter("description"));
				Category category = categoryManager.findById(Integer.parseInt(request.getParameter("container-id")));
				forum.setCategory(category);
				forum.setTotalPosts(0);
				forum.setTotalTopics(0);
				
				forumManager.create(forum);
				
				request.getSession().setAttribute("messageOk", "You have created the new forum. Thx.");
				
				doGet(request, response);
			}
		}
		else {
			
			doGet(request, response);
		}
	}
}
