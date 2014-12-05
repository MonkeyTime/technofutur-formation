package be.techno.repository;

import java.util.ArrayList;
import java.util.List;

import be.techno.Personne;

public class MockPersonneRepository implements PersonneRepository{

	private List<Personne> personnes = new ArrayList<Personne>();
	
	@Override
	public List<Personne> findAll() {		
		return personnes;
	}

	@Override
	public Personne findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Personne> findByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createPersonne(Personne p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePersonne(Personne p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePersonne(Personne p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNomById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}


}
