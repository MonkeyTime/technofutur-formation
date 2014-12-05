package be.technofutur.spring;

import java.util.List;

public interface IPersonRepository {

	public List<Person> findAll();
	public Person  findById(int id);
	public List<Person> findByName(String name);
	public void createPerson(Person p);
	public void updatePerson(Person p);
	public void deletePerson(Person p);
	
	public String getNameById(int id);
}
