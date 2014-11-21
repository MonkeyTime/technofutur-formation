package be.technofutur.spring;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		BeanFactory factory = new FileSystemXmlApplicationContext("applicationContext.xml");
		
		IPersonRepository repo = (IPersonRepository) factory.getBean("userRepo");
		
		List<Person> personnes = repo.findAll();
		
		for(Person item : personnes) {
			
			System.out.println(item.toString());
		}
		
		List<Person> personnes2 = repo.findByName("Tata");
		
		for(Person item : personnes2) {
			
			System.out.println(item.toString());
		}
		
		//repo.deletePerson(repo.findById(7));
	}

}
