package be.techno.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ClientManager
 */
@Stateless
public class ClientManager implements ClientManagerLocal {

	@EJB(beanName="clientRepo")
	private ClientRepository repo;

	@Override
	public void testClient() {
		// TODO Auto-generated method stub
		repo.testClient();
	}

}
