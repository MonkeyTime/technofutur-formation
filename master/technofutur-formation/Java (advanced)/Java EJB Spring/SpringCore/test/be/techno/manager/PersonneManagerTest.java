package be.techno.manager;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import be.techno.Personne;
import be.techno.repository.MockPersonneRepository;
import static org.junit.Assert.*;

public class PersonneManagerTest {

	@Test
	public void testADoublon(){		
		PersonneManager pm = new PersonneManager();
		MockPersonneRepository mock = new MockPersonneRepository();
		pm.setRepo(mock);	
		
		assertEquals(false, pm.aDoublon());
		
		List<Personne> list = new ArrayList<Personne>();
		list.add(new Personne("toto"));
		list.add(new Personne("titi"));
		mock.setPersonnes(list);
		assertEquals(false, pm.aDoublon());
		
		
		list.add(new Personne("toTo"));		
		assertEquals(true, pm.aDoublon());
		
	}
	
}
