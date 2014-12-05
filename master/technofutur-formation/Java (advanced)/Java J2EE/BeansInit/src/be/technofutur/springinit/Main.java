package be.technofutur.springinit;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		BeanFactory factory = new FileSystemXmlApplicationContext("applicationContext.xml");

		Person p = (Person) factory.getBean("Dupont");
		
		System.out.println(p);
	}

}
