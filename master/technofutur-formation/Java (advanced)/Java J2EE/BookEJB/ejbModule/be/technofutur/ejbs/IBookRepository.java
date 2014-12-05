package be.technofutur.ejbs;

import java.util.List;

import javax.ejb.Local;

import be.technofutur.entities.Book;

@Local
public interface IBookRepository {

	List<Book> findAll();

	Book findByTitle(final String title);

	Book saveBook(final Book book);

	void deleteBook(final Book book);
}
