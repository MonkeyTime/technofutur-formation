package be.techno.servlet.manager;

import java.util.List;

import be.techno.servlet.Personne;
import be.techno.servlet.repository.PersonneRepository;

public class PersonneManager {

	private PersonneRepository repo;

	public void setRepo(PersonneRepository repo) {
		this.repo = repo;
	}
	
	public void createPersonne(String nom){
		Personne p = new Personne();
		p.setNom(nom);
		
		this.repo.createPersonne(p);
	}

	public List<Personne> getList() {
		
		return this.repo.findAll();
	}

	public void deletePersonne(int id) {
		
		this.repo.deletePersonne(this.repo.getPersonneById(id));
	}

	public void updatePersonne(int id) {
		
		this.repo.updatePersonne(this.repo.getPersonneById(id));
	}

	public Personne getPersonneById(int id) {
		return this.repo.getPersonneById(id);
	}
}
