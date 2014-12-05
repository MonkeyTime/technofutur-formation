package be.techno.servlet.repository;

import java.util.List;

import be.techno.servlet.Personne;

public interface PersonneRepository {
	
	public void createPersonne(Personne p);
	public void updatePersonne(Personne p);
	public void deletePersonne(Personne p);
	
	public Personne getPersonneByName(String name);
	List<Personne> findAll();
	Personne getPersonneById(int id);
	
	
}
