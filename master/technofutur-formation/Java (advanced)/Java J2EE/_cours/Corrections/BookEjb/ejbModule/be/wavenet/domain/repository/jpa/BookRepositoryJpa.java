package be.wavenet.domain.repository.jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.wavenet.domain.entity.Book;
import be.wavenet.domain.exceptions.ValidationException;
import be.wavenet.domain.repository.BookRepository;

//(est utilisé par injection de dépendance dans le BookManagerBean)
@Stateless(name = "BookRepository")
public class BookRepositoryJpa implements BookRepository {

	@PersistenceContext(unitName = "ejbBook")
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	protected EntityManager getEntityManager() {
		if (entityManager == null)
			throw new java.lang.IllegalStateException("Unknown EntityManager");

		return entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAll() {
		Query query = getEntityManager().createNamedQuery("Book.findAll");
		return query.getResultList();
	}

	@Override
	public Book findByTitle(String title) {
		if (title == null || title.trim().length() == 0)
			throw new ValidationException("Invalid title");

		Query query = getEntityManager().createNamedQuery("Book.findByTitle");
		query.setParameter("title", title);

		return (Book) query.getSingleResult();
	}

	@Override
	public void delete(final Book book) {
		if (book == null)
			throw new ValidationException("Invalid entity");

		// faire getEntityManager().remove(getEntityManager().merge(book));,
		// c'est mieux que getEntityManager().remove(book); parce que si jamais
		// book a été modifié avant le remove, il ne serait pas supprimé de la
		// DB sans le merge
		getEntityManager().remove(getEntityManager().merge(book));
	}

	@Override
	public Book save(final Book book) {
		if (book == null)
			throw new ValidationException("Invalid entity");

		return getEntityManager().merge(book);
	}

	@Override
	public void create(Book book) {
		if (book == null)
			throw new ValidationException("Invalid entity");

		getEntityManager().persist(book);
	}

	@Override
	public Book findById(int id) {
		Query query = getEntityManager().createNamedQuery("Book.findById");
		query.setParameter("id", id);

		return (Book) query.getSingleResult();
		// return (Book) query.getResultList().get(0);
	}

}
