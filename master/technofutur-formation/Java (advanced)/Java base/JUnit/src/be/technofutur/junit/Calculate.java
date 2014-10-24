package be.technofutur.junit;

public class Calculate {

	public Calculate() {
		
	}
	
	
	public static int sum(int a, int b) {
		
		return a + b;
	}
	
	public static double divide(double a, double b) throws Exception {
		
		if(b == 0) {
			
			throw new Exception("Divide by zero !");
		}
		
		return a / b;
	}

}
