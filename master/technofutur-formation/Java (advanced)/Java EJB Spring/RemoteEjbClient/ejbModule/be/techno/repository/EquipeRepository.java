package be.techno.repository;

import java.util.List;

import javax.ejb.Local;

import be.techno.domain.Equipe;

@Local
public interface EquipeRepository {

	public List<Equipe> findAll();	

	public void addPts(Equipe e, int pts);
}
