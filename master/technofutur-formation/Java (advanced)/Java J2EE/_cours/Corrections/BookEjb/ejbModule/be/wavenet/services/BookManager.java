package be.wavenet.services;

import java.util.List;

import be.wavenet.domain.entity.Book;

public interface BookManager {

	void createBook(final Book book);

	List<Book> findAll();

	Book findByTitle(final String title);
	
	Book findById(final int id);
	
	Book saveBook(final Book book);
	
	void deleteBook(final Book book);

}
