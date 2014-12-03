package be.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyHello
 */
@WebServlet("/MyHello")
public class MyHello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyHello() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("username") == null
				|| request.getSession().getAttribute("username").equals("")) {

			if (request.getParameter("username") == null
					|| request.getParameter("username").equals("")) {

				request.getRequestDispatcher("form.html").forward(request, response);

			} else {
				String username = request.getParameter("username");
				request.getSession().setAttribute("username", username);
				request.getRequestDispatcher("/MyHello").forward(request, response);
			}
		} else {
			SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE dd MMMMM yyyy");
			SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
			Date now = new Date();
			
			request.setAttribute("date", dateFormat.format(now));
			request.setAttribute("time", timeFormat.format(now));
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
