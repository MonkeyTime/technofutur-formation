package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.technofutur.labo.entities.Category;

/**
 * Session Bean implementation class Category
 */
@Stateless
@Local
public class CategoryManager implements ICategoryManager {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public CategoryManager() {}

	@Override
	public Category create(Category category) {
		
		em.persist(category);
		
		return category;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAll() {
		
		return em.createQuery("SELECT c FROM Category c").getResultList();
	}

	@Override
	public Category findById(int id) {
		
		Query query = em.createQuery("SELECT c FROM Category c WHERE c.id = :id");
		
		query.setParameter("id", id);
		
		@SuppressWarnings("unchecked")
		List<Category> cats = query.getResultList();
		
		if(cats.size() > 0) {
			
			return cats.get(0);
		}
		
		return null;	
	}

	@Override
	public Category save(Category category) {
		
		em.merge(category);
		
		return category;
	}
	
	@Override
	public void delete(Category category) {
		
		em.remove(em.merge(category));
	}

	@Override
	public void delete(int id) {
		
		em.remove(em.merge(this.findById(id)));
	}

}
