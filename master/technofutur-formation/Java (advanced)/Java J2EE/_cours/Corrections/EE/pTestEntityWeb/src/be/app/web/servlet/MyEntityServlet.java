package be.app.web.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.app.ejb.domain.entity.MyEntity;
import be.app.ejb.domain.repository.MyEntityRepository;

/**
 * Servlet implementation class MyEntityServlet
 */
@WebServlet("/MyEntityServlet")
public class MyEntityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private MyEntityRepository mer;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyEntityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyEntity me = new MyEntity();
		me.setId(5);
		mer.create(me);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
