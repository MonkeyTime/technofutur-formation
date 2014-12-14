package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.technofutur.labo.entities.Forum;

/**
 * Session Bean implementation class Forum
 */
@Stateless
@Local
public class ForumManager implements IForumManager {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ForumManager() {}

	@Override
	public Forum create(Forum forum) {
		
		em.persist(forum);
		
		return forum;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Forum> findAll() {
		
		return em.createQuery("SELECT f FROM Forum f").getResultList();
	}

	@Override
	public Forum findById(int id) {
		
		Query query = em.createQuery("SELECT f FROM Forum f WHERE f.id = :id");
		
		query.setParameter("id", id);
		
		return (Forum)query.getSingleResult();	
	}

	@Override
	public Forum save(Forum forum) {
		
		em.merge(forum);
		
		return forum;
	}

	@Override
	public void delete(Forum forum) {
		
		em.remove(em.merge(forum));
	}
	
	@Override
	public void delete(int id) {
		
		em.remove(em.merge(this.findById(id)));
	}

}
