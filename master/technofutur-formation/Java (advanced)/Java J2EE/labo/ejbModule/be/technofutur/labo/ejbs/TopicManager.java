package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.technofutur.labo.entities.Topic;

/**
 * Session Bean implementation class Forum
 */
@Stateless
@LocalBean
public class TopicManager implements ITopicManager {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public TopicManager() {}

	@Override
	public Topic create(Topic topic) {

		em.persist(topic);

		return topic;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> findAll() {
		
		return em.createQuery("SELECT t FROM topic t").getResultList();
	}

	@Override
	public Topic findById(int id) {
		
		Query query = em.createQuery("SELECT t FROM topic t WHERE t.id = :id");
		
		query.setParameter("id", id);
		
		return (Topic)query.getSingleResult();	
	}

	@Override
	public Topic save(Topic topic) {
		
		em.merge(topic);
		
		return topic;
	}

	@Override
	public void delete(Topic topic) {
		
		em.remove(em.merge(topic));
	}
	
	@Override
	public void delete(int id) {
		
		em.remove(em.merge(this.findById(id)));
	}

}
