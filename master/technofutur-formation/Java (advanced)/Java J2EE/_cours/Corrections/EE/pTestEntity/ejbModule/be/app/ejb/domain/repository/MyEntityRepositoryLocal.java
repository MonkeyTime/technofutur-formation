package be.app.ejb.domain.repository;

import javax.ejb.Local;

import be.app.ejb.domain.entity.MyEntity;

@Local
public interface MyEntityRepositoryLocal {

	public MyEntity create(MyEntity me);
	
}
