package be.wavenet.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.wavenet.domain.entity.BandeDessinee;
import be.wavenet.domain.entity.Book;
import be.wavenet.domain.entity.Roman;
import be.wavenet.services.BookManagerLocal;

public class AddBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB(beanName="BookManager")
	private BookManagerLocal bookManager;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/createBook.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		// On récupère le contenu des input via leur name
		String title = request.getParameter("title");
		String author = request.getParameter("author");

		// Création du livre
		Book book;
		if (request.getParameter("bd") != null && request.getParameter("bd").equals("on")) {
			String editor = request.getParameter("editor");
			book = new BandeDessinee(author, title, editor);
		} else {
			int nbPages = Integer.parseInt(request.getParameter("nbPages"));
			book = new Roman(author, title, nbPages);
		}

		// Ajout du livre dans la DB
		bookManager.createBook(book);

		// Après l'action, la servlet nous redirige sur une nouvelle page
		response.sendRedirect("index.do");
	}
}
