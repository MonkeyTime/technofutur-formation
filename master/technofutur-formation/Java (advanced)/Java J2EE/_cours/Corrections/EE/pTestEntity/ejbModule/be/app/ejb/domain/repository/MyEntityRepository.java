package be.app.ejb.domain.repository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.app.ejb.domain.entity.MyEntity;

/**
 * Session Bean implementation class MyEntityRepository
 */
@Stateless
@LocalBean
public class MyEntityRepository implements MyEntityRepositoryLocal {

	@PersistenceContext(unitName="entity-unit")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public MyEntityRepository() { }

	@Override
	public MyEntity create(MyEntity myEntity) {
		em.persist(myEntity);
		return myEntity;
	}
    

}
