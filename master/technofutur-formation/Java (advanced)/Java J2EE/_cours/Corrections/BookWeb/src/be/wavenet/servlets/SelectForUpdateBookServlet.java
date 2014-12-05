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

public class SelectForUpdateBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB(beanName="BookManager")
	private BookManagerLocal bookManager;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> books = bookManager.findAll();
		request.setAttribute("library", books);
		request.getRequestDispatcher("/WEB-INF/views/updateBook.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// On récupère le contenu des input via leur name
		int id = Integer.parseInt(request.getParameter("listBook"));

		// Suppression du livre dans la DB
		Book b = bookManager.findById(id);

		request.getSession().setAttribute("bookToUpdate", b);
		
		// Après l'action, la servlet nous redirige sur une nouvelle page
		response.sendRedirect("update.do");
	}
}
