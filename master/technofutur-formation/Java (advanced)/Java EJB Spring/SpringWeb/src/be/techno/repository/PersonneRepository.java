package be.techno.repository;

import java.util.List;

import be.techno.Personne;

public interface PersonneRepository {
	
	public List<Personne> findAll();
	public Personne findById(int id);
	public List<Personne> findByNom(String nom);
	public void createPersonne(Personne p);
	public void updatePersonne(Personne p);
	public void deletePersonne(Personne p);
	
	public String getNomById(int id);
	
	
}
