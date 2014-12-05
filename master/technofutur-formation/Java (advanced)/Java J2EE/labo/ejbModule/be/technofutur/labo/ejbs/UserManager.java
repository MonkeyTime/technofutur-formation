package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.technofutur.labo.entities.User;

/**
 * Session Bean implementation class Forum
 */
@Stateless
@LocalBean
public class UserManager implements IUserManager {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public UserManager() {}

	@Override
	public User createUser(User user) {

		em.persist(user);

		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		
		return em.createQuery("SELECT u FROM user u").getResultList();
	}

	@Override
	public User findByNickname(String nickname) {
		
		Query query = em.createQuery("SELECT u FROM user u WHERE u.nickname = :nickname");
		
		query.setParameter("nickname", nickname);
		
		return (User)query.getSingleResult();	
	}

	@Override
	public User saveUser(User user) {
		
		em.merge(user);
		
		return user;
	}

	@Override
	public void deleteUser(User user) {
		
		em.remove(em.merge(user));
	}

}
