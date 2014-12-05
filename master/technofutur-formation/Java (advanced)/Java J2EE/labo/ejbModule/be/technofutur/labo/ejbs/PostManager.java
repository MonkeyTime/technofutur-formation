package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.technofutur.labo.entities.Post;

/**
 * Session Bean implementation class Forum
 */
@Stateless
@LocalBean
public class PostManager implements IPostManager {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public PostManager() {}

	@Override
	public Post create(Post post) {

		em.persist(post);

		return post;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> findAll() {
		
		return em.createQuery("SELECT p FROM post p").getResultList();
	}

	@Override
	public Post findById(int id) {
		
		Query query = em.createQuery("SELECT p FROM post p WHERE p.id = :id");
		
		query.setParameter("id", id);
		
		return (Post)query.getSingleResult();	
	}

	@Override
	public Post save(Post post) {
		
		em.merge(post);
		
		return post;
	}

	@Override
	public void delete(Post post) {
		
		em.remove(em.merge(post));
	}
	
	public void delete(int id) {
		
		em.remove(em.merge((Post)this.findById(id)));
	}

}
