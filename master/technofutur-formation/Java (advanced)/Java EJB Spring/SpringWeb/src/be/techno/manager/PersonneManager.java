package be.techno.manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import be.techno.Personne;
import be.techno.repository.PersonneRepository;

@Service("personneManager")
public class PersonneManager {

	@Resource(name="personneRepo")
	private PersonneRepository repo;

	public void setRepo(PersonneRepository repo) {
		this.repo = repo;
	}
	
	public void createPersonne(String nom){
		Personne p = new Personne();
		p.setNom(nom);
		
		repo.createPersonne(p);
	}
	
	public List<Personne> getPersonnes(){
		return repo.findAll();
	}

	public void deletePersonne(int parameter) {
		repo.deletePersonne(repo.findById(parameter));		
	}

	public Personne getPersonne(Integer id) {	
		return repo.findById(id);
	}

	public void updatePersonne(int id, String nom) {
		Personne p = repo.findById(id);
		p.setNom(nom);
		
		repo.updatePersonne(p);		
	}
	
}
