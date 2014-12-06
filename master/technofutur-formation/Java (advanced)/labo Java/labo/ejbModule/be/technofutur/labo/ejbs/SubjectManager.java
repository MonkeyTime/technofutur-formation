package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.technofutur.labo.entities.Subject;

/**
 * Session Bean implementation class Forum
 */
@Stateless
@LocalBean
public class SubjectManager implements ISubjectManager {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public SubjectManager() {}

	@Override
	public Subject createSubject(Subject subject) {

		em.persist(subject);

		return subject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> findAll() {
		
		return em.createQuery("SELECT s FROM subject s").getResultList();
	}

	@Override
	public Subject findByTitle(String title) {
		
		Query query = em.createQuery("SELECT s FROM subject s WHERE s.title = :title");
		
		query.setParameter("title", title);
		
		return (Subject)query.getSingleResult();	
	}

	@Override
	public Subject saveSubject(Subject subject) {
		
		em.merge(subject);
		
		return subject;
	}

	@Override
	public void deleteSubject(Subject subject) {
		
		em.remove(em.merge(subject));
	}

}
