package be.technofutur.appservlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HomeServlet implementation class HomeServlet
 */
@WebServlet(
		name = "HomeServlet", 
		description = "servlet appelé comme /home pour la web app", 
		urlPatterns = {
				"/index.html"
		}, 
		initParams = { 
				@WebInitParam(name = "db_hostname", value = "localhost")
		})
public class Home extends HttpServlet {
   
    /**
	 * 
	 */
	private static final long serialVersionUID = -6907587342305145318L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("Constructor");
    }

	/**
	 * @see HomeServlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Init");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Get");
		response.setContentType("text/html");
		response.getWriter().print("<html><head></head><body><form method=\"POST\" action=\"\"><input type=\"text\" name=\"user\" /> <input type=\"submit\" value=\"send\" /></form></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Post");
		String user = request.getParameter("user");
		response.setContentType("text/html");
		response.getWriter().print("<html><head></head><body>Hello " + user.toString() + "</body></html>");
	}
}
