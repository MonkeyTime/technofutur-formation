package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.technofutur.labo.entities.User;

/**
 * Session Bean implementation class Forum
 */
@Stateless
@Local
public class UserManager implements IUserManager {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public UserManager() {}

	@Override
	public User create(User user) {

		em.persist(user);

		return user;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		
		return em.createQuery("SELECT u FROM User u").getResultList();
	}

	@Override
	public User findById(int id) {
		
		Query query = em.createQuery("SELECT u FROM User u WHERE u.id = :id");
		
		query.setParameter("id", id);
		
		return (User)query.getSingleResult();
	}
	
	@Override
	public User findByUsername(String username) {
		
		Query query = em.createQuery("SELECT u FROM User u WHERE u.userName = :username");
		
		query.setParameter("username", username);
		
		return (User)query.getSingleResult();
	}

	@Override
	public User save(User user) {
		
		em.merge(user);
		
		return user;
	}

	@Override
	public void delete(User user) {
		
		em.remove(em.merge(user));
	}
	
	@Override
	public void delete(int id) {
		
		em.remove(em.merge(this.findById(id)));
	}
}
