package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.technofutur.labo.entities.Post;

/**
 * Session Bean implementation class Forum
 */
@Stateless
@Local
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
		
		return em.createQuery("SELECT p FROM Post p").getResultList();
	}

	@Override
	public Post findById(int id) {
		
		Query query = em.createQuery("SELECT p FROM Post p WHERE p.id = :id");
		
		query.setParameter("id", id);

		@SuppressWarnings("unchecked")
		List<Post> posts = query.getResultList();
		
		if(posts.size() > 0) {
			
			return posts.get(0);
		}
		
		return null;	
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
		
		em.remove(em.merge(this.findById(id)));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> findByTopicId(int topicId) {
		
		Query query = em.createQuery("SELECT p FROM Post p WHERE p.topic.id = :topicId");
		
		query.setParameter("topicId", topicId);
		
		return query.getResultList();	
	}

}
