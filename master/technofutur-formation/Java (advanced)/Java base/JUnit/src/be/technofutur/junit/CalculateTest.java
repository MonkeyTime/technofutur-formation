package be.technofutur.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculateTest {

	public CalculateTest() {
		
	}
	
	@Before
	public void initBefore() {
		
	}
	
	@After
	public void initAfter() {
		
	}
	
	@Test
	public void testSum() {
		assertEquals(10, Calculate.sum(8, 2));
		assertEquals(15, Calculate.sum(10, 5));
	}
	
	@Test(expected=Exception.class)
	public void testDivide() throws Exception {
		
		assertEquals(5, Calculate.divide(10,  2), 1);
		assertEquals(5, Calculate.divide(10,  0), 1);
	}

}
