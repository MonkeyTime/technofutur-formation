package be.techno.ejb;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class ClientRepository
 */
@Stateless(name="clientRepo")
public class ClientRepository implements ClientRepositoryLocal {

    /**
     * Default constructor. 
     */
    public ClientRepository() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void testClient() {
		System.out.println("Hello world");
	}

}
