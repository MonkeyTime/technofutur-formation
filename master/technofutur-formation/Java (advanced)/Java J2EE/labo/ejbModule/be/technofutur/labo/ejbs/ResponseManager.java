package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.technofutur.labo.entities.Response;

/**
 * Session Bean implementation class Forum
 */
@Stateless
@LocalBean
public class ResponseManager implements IResponseManager {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ResponseManager() {}

	@Override
	public Response createResponse(Response response) {

		em.persist(response);

		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Response> findAll() {
		
		return em.createQuery("SELECT r FROM response r").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Response> findByContent(String content) {
		
		Query query = em.createQuery("SELECT r FROM response r WHERE r.content = :content");
		
		query.setParameter("content", content);
		
		return query.getResultList();
	}

	@Override
	public Response saveResponse(Response response) {
		
		em.merge(response);
		
		return response;
	}

	@Override
	public void deleteResponse(Response response) {
		
		em.remove(em.merge(response));
	}

}
