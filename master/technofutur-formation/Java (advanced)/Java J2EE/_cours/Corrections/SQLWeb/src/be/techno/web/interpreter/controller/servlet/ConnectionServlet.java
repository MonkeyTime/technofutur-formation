package be.techno.web.interpreter.controller.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.techno.web.interpreter.controller.exceptions.ConnectParamException;
import be.techno.web.interpreter.controller.wrapper.ConnectionWrapper;

/**
 * Servlet implementation class ConnectionServlet
 */
@WebServlet("/doConnect")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("url");
		String user = request.getParameter("user");
		String pwd = request.getParameter("password");		
		
		if(url==null || user==null || pwd==null) {
			ServletHelper.errorForwarding(request, response,
					new ConnectParamException(url, user, pwd), getServletContext().getContextPath() + "/");
		}
		
		try {
			Connection connection = DriverManager.getConnection(url, user, pwd);
			System.out.println("DB Connection: ok");
			
			manageConnection(request.getSession(true), connection, url, user, pwd);
			System.out.println("DB Connection: replaced");
			
		} catch (Exception e) {
			e.printStackTrace();
			ServletHelper.errorForwarding(request, response, e, getServletContext().getContextPath()+"/");
			return;
		}
		
		
		response.sendRedirect("query.html");
	}

	
	public void manageConnection(HttpSession session, Connection newConnection, String url, String user, String password) throws Exception {
		
		ConnectionWrapper wConnection = (ConnectionWrapper) session.getAttribute("user.db.connection");
		
		/* MUST test if .conn() is different from null because after deserialization (start of webapp) the session is restored
		 * and transient references are set to null */
		if(wConnection!=null && wConnection.conn()!=null) {
			Connection oldConnection = wConnection.conn();
			try {
				oldConnection.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception("Error when closing old connection");
			}
		}
		
		session.setAttribute("user.db.connection", new ConnectionWrapper(newConnection));
		session.setAttribute("user.db.url", url);
		session.setAttribute("user.db.user", user);
		session.setAttribute("user.db.password", password);
		
		/* Add reference to the connection into the App Scope to clean them when webapp stops */
		Object o = getServletContext().getAttribute("storedSessions");
    	if( o!=null && (o instanceof ConcurrentHashMap) ) {
    		@SuppressWarnings("unchecked")
			ConcurrentHashMap<HttpSession, Connection> storedUserSessions = (ConcurrentHashMap<HttpSession, Connection>) o;
    		storedUserSessions.put(session, newConnection);
    	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
