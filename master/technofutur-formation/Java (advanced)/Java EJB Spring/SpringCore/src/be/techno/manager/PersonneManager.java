package be.techno.manager;

import java.util.List;

import be.techno.Personne;
import be.techno.repository.PersonneRepository;

public class PersonneManager {

	private PersonneRepository repo;

	public void setRepo(PersonneRepository repo) {
		this.repo = repo;
	}
	
	public void createPersonne(String nom){
		Personne p = new Personne();
		p.setNom(nom);
		
		repo.createPersonne(p);
	}
	
	public boolean aDoublon(){
		List<Personne> personnes = repo.findAll();
		for (int i = 0 ; i < personnes.size() ; i++){
			Personne p = personnes.get(i);
			for (int j = i+1 ; j < personnes.size() ; j++){
				if (p.getNom().equalsIgnoreCase(personnes.get(j).getNom()))
					return true;
			}
		}
		
		return false;
	}
	
}
