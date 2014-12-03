package be.wavenet.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String DRIVER = "com.mysql.jdbc.Driver";

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("url");
		String user = request.getParameter("user");
		String pwd = request.getParameter("password");		
		
		Connection connection = null;
		
		try {			
			connection = connect(url, user, pwd);
		} catch (Exception e) {
			ServletHelper.redirectErrors(request, response, e, "index.html");
			return;
		}

		HttpSession clientSession = request.getSession(true);

		clientSession.setAttribute("connection", connection);
		response.sendRedirect("query.html");
	}

	private Connection connect(String url, String user, String pwd) throws Exception {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			throw new Exception("Failed to connect, wrong driver");
		}
		
		if (url == null || url.trim().length() == 0)
			throw new Exception("Invalid url");

		if (user == null || user.trim().length() == 0)
			throw new Exception("Invalid user");
		
		if (pwd == null || pwd.trim().length() == 0)
			throw new Exception("Invalid password");
		
		try {
			return DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			throw new Exception(
					"Failed to connect, invalid connection parameters");
		}
	}

}
