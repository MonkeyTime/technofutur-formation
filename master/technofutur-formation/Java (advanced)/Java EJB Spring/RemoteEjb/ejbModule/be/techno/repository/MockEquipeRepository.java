package be.techno.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import be.techno.domain.Equipe;
import be.techno.repository.EquipeRepository;

/**
 * Session Bean implementation class EquipeRepositoryJdbc
 */
@Stateful(name="equipeRepository")
public class MockEquipeRepository implements EquipeRepository {
	
	private List<Equipe> equipes;
	
	public MockEquipeRepository() {
		this.equipes = new ArrayList<Equipe>();
		
		this.equipes.add(new Equipe("Arsenal",17));
		this.equipes.add(new Equipe("Aston Villa",16));
		this.equipes.add(new Equipe("Burnley",19));
		this.equipes.add(new Equipe("Chelsea",32));
		this.equipes.add(new Equipe("Crystal Palace",15));
		this.equipes.add(new Equipe("Everton",17));
		this.equipes.add(new Equipe("Hull City",11));
		this.equipes.add(new Equipe("Leicester City",18));
		this.equipes.add(new Equipe("Liverpool",14));
		this.equipes.add(new Equipe("Manchester City",24));
		this.equipes.add(new Equipe("Manchester United",19));
		this.equipes.add(new Equipe("Newcastle United",5));
		this.equipes.add(new Equipe("Queens Park Rangers",8));
		this.equipes.add(new Equipe("Southampton",26));
		this.equipes.add(new Equipe("Stoke City",15));
		this.equipes.add(new Equipe("Sunderland",13));
		this.equipes.add(new Equipe("Swansea City",18));
		this.equipes.add(new Equipe("Tottenham Hotspur",10));
		this.equipes.add(new Equipe("West Bromwich Albion",13));
		this.equipes.add(new Equipe("West Ham United",6));
	}

	@Override
	public List<Equipe> findAll() {
		return equipes;
	}

	@Override
	public void addPts(Equipe e, int pts) {
		int i = this.equipes.indexOf(e);		
	
		if ( i != -1){
			Equipe equipe = this.equipes.get(i);
			equipe.setPts(equipe.getPts() + pts);
		}
		
	}

    

}
