package be.technofutur.entity;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;

public class Main {

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("se-persistence");
	}

}
