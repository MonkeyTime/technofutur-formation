package be.technofutur.ejbs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.technofutur.entities.Book;

/**
 * Session Bean implementation class BookRepositoryMem
 */
@Stateless
@LocalBean
public class BookRepository implements IBookRepository {

	private List<Book> books;
	
    /**
     * Default constructor. 
     */
    public BookRepository() {
    	@SuppressWarnings("unused")
		List<Book> books = new ArrayList<Book>();
    }

	@Override
	public List<Book> findAll() {
		
		return this.books;
	}

	@Override
	public Book findByTitle(String title) {
		
		for(Book book : books) {
			
			if(book.getTitle() == title) {
				
				return book;
			}
		}
		
		return null;
	}

	@Override
	public Book saveBook(Book book) {
		
		this.books.add(book);
		
		return book;
	}

	@Override
	public void deleteBook(Book book) {
		
		this.books.remove(book);
	}

}
