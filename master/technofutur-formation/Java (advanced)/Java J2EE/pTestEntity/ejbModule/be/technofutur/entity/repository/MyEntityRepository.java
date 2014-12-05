package be.technofutur.entity.repository;

import javax.persistence.EntityManager;

import be.technofutur.entity.MyEntity;


public class MyEntityRepository implements MyEntityRepositoryLocal {

	private EntityManager em;
	
	@Override
	public MyEntity create(MyEntity me) {
		
		em.persist(me);
		
		return me;
	}

}
