package be.app.ejb.domain.repository;

import javax.persistence.EntityManager;

import be.app.ejb.domain.entity.MyEntity;

public class MyEntityRepositoryJpa implements MyEntityRepository {

	private EntityManager entityManager;
	
	public MyEntityRepositoryJpa(EntityManager em) {
		setEntityManager(em);
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void closeRepository() {
		if(entityManager.isOpen())
			entityManager.close();
	}
	
	public MyEntity create(MyEntity myEntity) {
		entityManager.getTransaction().begin();
		entityManager.persist(myEntity);
		entityManager.getTransaction().commit();
		return myEntity;
	}
	
	public MyEntity find(int id) {
		return entityManager.find(MyEntity.class, id);
	}
	
	public MyEntity update(MyEntity myEntity) {
		entityManager.getTransaction().begin();
		MyEntity managed = entityManager.merge(myEntity);
		entityManager.getTransaction().commit();
		return managed;
	}
	
	/**
	 * Merge avant le remove afin de synchroniser l'entity bean
	 * avec son état en DB.
	 */
	public void remove(MyEntity myEntity) {
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.merge(myEntity));
		entityManager.getTransaction().commit();
	}
}
