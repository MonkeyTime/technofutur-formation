package be.wavenet.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.wavenet.domain.entity.Book;
import be.wavenet.services.BookManagerLocal;


public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB(beanName="BookManager")
	private BookManagerLocal bookManager;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> books = bookManager.findAll();
		request.setAttribute("library", books);
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}
}
