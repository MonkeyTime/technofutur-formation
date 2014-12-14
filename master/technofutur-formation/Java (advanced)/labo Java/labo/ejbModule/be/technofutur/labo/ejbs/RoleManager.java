package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.technofutur.labo.entities.Role;

/**
 * Session Bean implementation class Role
 */
@Stateless
@Local
public class RoleManager implements IRoleManager {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public RoleManager() {}

	@Override
	public Role create(Role role) {
		
		em.persist(role);
		
		return role;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAll() {
		
		return em.createQuery("SELECT r FROM Role r").getResultList();
	}

	@Override
	public Role findById(int id) {
		
		Query query = em.createQuery("SELECT r FROM Role r WHERE r.id = :id");
		
		query.setParameter("id", id);
		
		return (Role)query.getSingleResult();	
	}

	@Override
	public Role save(Role role) {
		
		em.merge(role);
		
		return role;
	}

	@Override
	public void delete(Role role) {
		
		em.remove(em.merge(role));
	}
	
	@Override
	public void delete(int id) {
		
		em.remove(em.merge(this.findById(id)));
	}

}
