package be.technofutur.entity;

import javax.ejb.Remote;
import javax.persistence.EntityManager;

@Remote
public interface EntityManagerFactoryRemote {

	EntityManager create(EntityManager em);
}
