package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.technofutur.labo.entities.Topic;

/**
 * Session Bean implementation class Forum
 */
@Stateless
@Local
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
		
		return em.createQuery("SELECT t FROM Topic t").getResultList();
	}

	@Override
	public Topic findById(int id) {
		
		Query query = em.createQuery("SELECT t FROM Topic t WHERE t.id = :id");
		
		query.setParameter("id", id);
		
		@SuppressWarnings("unchecked")
		List<Topic> topics = query.getResultList();
		
		if(topics.size() > 0) {
			
			return topics.get(0);
		}
		
		return null;
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
