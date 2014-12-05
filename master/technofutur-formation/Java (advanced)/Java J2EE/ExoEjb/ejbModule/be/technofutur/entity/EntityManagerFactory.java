package be.technofutur.entity;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Session Bean implementation class EntityManagerFactory
 */
@Stateless
@LocalBean
public class EntityManagerFactory implements EntityManagerFactoryRemote {
	
    /**
     * Default constructor. 
     */
    public EntityManagerFactory() {}

	public EntityManager create(EntityManager em) {
		
		Persistence.createEntityManagerFactory("se-persistence");
		
		return em;
	}

}
