package be.app.ejb.domain.repository;

import be.app.ejb.domain.entity.MyEntity;

public interface MyEntityRepository {

	public void closeRepository();
	
	public MyEntity create(MyEntity myEntity);
	public MyEntity find(int id);
	public MyEntity update(MyEntity myEntity);
	public void remove(MyEntity myEntity);
}
