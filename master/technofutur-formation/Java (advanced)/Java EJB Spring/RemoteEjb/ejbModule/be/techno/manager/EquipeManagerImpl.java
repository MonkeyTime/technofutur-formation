package be.techno.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Stateful;

import be.techno.domain.Equipe;
import be.techno.manager.EquipeManager;
import be.techno.repository.EquipeRepository;

/**
 * Session Bean implementation class EquipeManagerImpl
 */
@Stateful
public class EquipeManagerImpl implements EquipeManager {

	@EJB(beanName="equipeRepository")
	private EquipeRepository repository;	
    

	@Override
	public List<Equipe> getAll() {
		return repository.findAll();
	}

	@Override
	public void addPts(Equipe e, int pts) {
		repository.addPts(e, pts);
		
	}

}
