package be.app;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import be.app.ejb.domain.entity.MyEntity;
import be.app.ejb.domain.repository.MyEntityRepository;
import be.app.ejb.domain.repository.MyEntityRepositoryJpa;

public class Main {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("se-persistence");
		MyEntityRepository mem = new MyEntityRepositoryJpa(emf.createEntityManager());
		
		MyEntity me = new MyEntity();
		me.setValue("Toto");
		mem.create(me);
		
		me = mem.find(1);
		System.out.println(me);
		
		if(me!=null) {
			me.setValue("Tutu");
			me = mem.update(me);
			System.out.println(me);
			
			//mem.remove(me);
		}
		else
			System.out.println("Entity not found");
		
		mem.closeRepository();
		emf.close();
	}

}
