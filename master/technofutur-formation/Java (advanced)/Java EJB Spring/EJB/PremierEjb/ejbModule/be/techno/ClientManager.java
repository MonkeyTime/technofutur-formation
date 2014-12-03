package be.techno;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.techno.repository.ClientRepository;
import be.techno.repository.ClientRepositoryLocal;

/**
 * Session Bean implementation class ClientManager
 */
@Stateless
public class ClientManager implements ClientManagerLocal {

	@EJB(beanName="clientRepo")
    private ClientRepositoryLocal repo;

	@Override
	public void testClient() {
		repo.testClient();
		
	}

}
