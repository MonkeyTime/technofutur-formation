package be.technofutur.labo.admin.ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.technofutur.labo.entities.Admin;

/**
 * Session Bean implementation class Admin
 */
@Stateless
@LocalBean
public class AdminManager implements IAdminManager {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public AdminManager() {}

	@Override
	public Admin createAdmin(Admin admin) {
		
		em.persist(admin);
		
		return admin;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> findAll() {
		
		return em.createQuery("SELECT a FROM admin a").getResultList();
	}

	@Override
	public Admin findByNickname(String nickname) {
		
		Query query = em.createQuery("SELECT a FROM admin a WHERE a.nickname = :nickname");
		
		query.setParameter("nickname", nickname);
		
		return (Admin)query.getSingleResult();	
	}

	@Override
	public Admin saveAdmin(Admin admin) {
		
		em.merge(admin);
		
		return admin;
	}

	@Override
	public void deleteAdmin(Admin admin) {
		
		em.remove(em.merge(admin));
	}

}
