package be.techno.servlet;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.techno.ejb.IClientManagerLocal;


public class MainServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5111152333462774884L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			Context ctx = new InitialContext();
			IClientManagerLocal cm = (IClientManagerLocal) ctx.lookup("java:global/PremierEjbEAR/PremierEjb/ClientManager");
		
			cm.testClient();
			
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
