package be.wavenet.domain.repository;

import java.util.List;

import javax.ejb.Local;

import be.wavenet.domain.entity.Book;

@Local
public interface BookRepository {
	List<Book> findAll();

	Book findByTitle(final String title);
	
	Book findById(final int id);

	Book save(final Book book);
	
	void delete(final Book book);
	
	void create(final Book book);
}
