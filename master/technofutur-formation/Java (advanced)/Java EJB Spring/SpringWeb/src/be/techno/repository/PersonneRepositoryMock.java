package be.techno.repository;

import java.util.ArrayList;
import java.util.List;

import be.techno.Personne;

public class PersonneRepositoryMock implements PersonneRepository{

	@Override
	public List<Personne> findAll() {
		List<Personne> pers = new ArrayList<Personne>();
		pers.add(new Personne("Mock1"));
		pers.add(new Personne("Mock2"));
		
		return pers;
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

}
