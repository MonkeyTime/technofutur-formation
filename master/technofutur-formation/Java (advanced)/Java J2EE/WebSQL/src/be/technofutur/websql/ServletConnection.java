package be.technofutur.websql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
	name = "Home",
	description = "servlet appelé comme index pour la web app", 
	urlPatterns = {
		"/"
})
public class ServletConnection extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1059422383130342408L;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConnection() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		req.getSession().setAttribute("actionURL", "/WebSQL");
		
		req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getParameter("pwd") != null && !req.getParameter("pwd").isEmpty() && req.getParameter("user") != null && !req.getParameter("user").isEmpty()) {
			
			Connection c = null;
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				c = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", req.getParameter("user"), req.getParameter("pwd"));
				
			} catch (SQLException | 
					InstantiationException | 
					IllegalAccessException | 
					ClassNotFoundException e) {
				
				req.getSession().setAttribute("errorMessage", e.getMessage());
				req.getRequestDispatcher("/jsp/error.jsp").forward(req, resp);
				
			} finally {
				
				if(c != null) {
					
					try {
						
						c.close();
						
					} catch (SQLException e) {
							
						req.getSession().setAttribute("errorMessage", e.getMessage());
						req.getRequestDispatcher("/jsp/error.jsp").forward(req, resp);
					}
				}
			}
			
			req.getSession().setAttribute("connector", c);
			req.getSession().setAttribute("actionURL", "/WebSQL/ServletQuery");
			req.getRequestDispatcher("/jsp/query.jsp").forward(req, resp);
		
		} else {
			
			req.getSession().setAttribute("errorMessage", "Please define url, user and password");
			req.getRequestDispatcher("/jsp/error.jsp").forward(req, resp);
		}
	}
}
