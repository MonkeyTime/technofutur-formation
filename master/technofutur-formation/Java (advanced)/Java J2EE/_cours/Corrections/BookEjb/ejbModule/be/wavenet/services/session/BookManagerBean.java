package be.wavenet.services.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.wavenet.domain.entity.Book;
import be.wavenet.domain.repository.BookRepository;
import be.wavenet.services.BookManagerLocal;
import be.wavenet.services.BookManagerRemote;

@Stateless(name = "BookManager")
public class BookManagerBean implements BookManagerLocal, BookManagerRemote {

	// Injection de dépendance : BookRepository
	//possibilité de specifier la classe du SessionBean injecté
	@EJB(beanName = "BookRepository"/*, beanInterface = BookRepository.class*/)
	private BookRepository repository;

	@Override
	public void createBook(final Book book) {
		repository.create(book);
	}

	@Override
	public List<Book> findAll() {
		return repository.findAll();
	}

	@Override
	public Book findByTitle(final String title) {
		return repository.findByTitle(title);
	}

	@Override
	public Book saveBook(Book book) {
		return repository.save(book);
	}

	@Override
	public void deleteBook(Book book) {
		repository.delete(book);
	}

	@Override
	public Book findById(int id) {
		return repository.findById(id);
	}

}
