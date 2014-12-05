package be.technofutur.ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.technofutur.entities.Book;

/**
 * Session Bean implementation class IBookManager
 */
@Stateless
@LocalBean
public class BookManager implements IBookManager {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public BookManager() {}

	@Override
	public Book createBook(Book book) {
		
		em.persist(book);
		
		return book;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAll() {
		
		return em.createQuery("select b from books b").getResultList();
	}

	@Override
	public Book findByTitle(String title) {
		
		Query query = em.createQuery("SELECT b FROM books b WHERE b.title = :title");
		
		query.setParameter("title", title);
		
		return (Book) query.getSingleResult();
		
	}

	@Override
	public Book saveBook(Book book) {
		
		em.merge(book);
		
		return book;
	}

	@Override
	public void deleteBook(Book book) {
		
		em.remove(em.merge(book));
	}

}
