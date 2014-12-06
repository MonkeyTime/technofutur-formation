package be.technofutur.labo.servlets;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technofutur.labo.ejbs.ICategoryManager;

public class CategoriesServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			Context ctx = new InitialContext();
			@SuppressWarnings("unused")
			ICategoryManager cm = (ICategoryManager) ctx.lookup("java:global/laboEAR/labo/CategoryManager");
			//cm.methodAccess();
			
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			Context ctx = new InitialContext();
			@SuppressWarnings("unused")
			ICategoryManager cm = (ICategoryManager) ctx.lookup("java:global/laboEAR/labo/CategoryManager");
			
			//cm.methodAccess();
			
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
	}
}
