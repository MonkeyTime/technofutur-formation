package be.techno.manager;


import java.util.List;

import javax.ejb.Remote;

import be.techno.domain.Equipe;

@Remote
public interface EquipeManager {

	public List<Equipe> getAll();
	
	public void addPts(Equipe e, int pts);	
	
}
