package be.techno;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import be.techno.repository.PersonneRepository;

public class Main {

	
	public static void main(String[] args) {	
		
		//BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		BeanFactory factory = new FileSystemXmlApplicationContext("applicationContext.xml");		
			
		PersonneRepository repo = (PersonneRepository) factory.getBean("userRepo");
		
		System.out.println("--FindAll");
		for(Personne p : repo.findAll()){
			System.out.println(p);
		}
		
		System.out.println("--FindById");
		System.out.println(repo.findById(2));
		
		System.out.println("--FindByNom");
		for(Personne p : repo.findByNom("Titi")){
			System.out.println(p);
		}
		
		System.out.println("--CreatePersonne");
		Personne newp = new Personne();
		newp.setNom("Yoyo");
		repo.createPersonne(newp);
		for(Personne p : repo.findByNom("Yoyo")){
			System.out.println(p);
		}
		
		System.out.println("--DeletePersonne");
		for(Personne p : repo.findByNom("Yoyo")){
			repo.deletePersonne(p);
		}
		
		System.out.println("--UpdatePersonne");
		Personne pp = repo.findById(1);
		pp.setNom("Updated");
		repo.updatePersonne(pp);	
		
		
		System.out.println("--getNomById");
		System.out.println(repo.getNomById(1));
		
	}
	
}
