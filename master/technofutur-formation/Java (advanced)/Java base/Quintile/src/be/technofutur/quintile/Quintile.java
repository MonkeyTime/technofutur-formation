package be.technofutur.quintile;
import java.util.Random;

/**
 * Quintile
 * 
 * Class Quintile test
 * 
 * @author forma1311
 *
 */
public class Quintile {
	
	/**
	 * main
	 * 
	 * main method
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		
		double result = 0.0;
		
		Random Random = new Random();
		
		result = Random.nextDouble();
		
		if(result < 0.20) {
			
			System.out.println("result < 1/5");	
			
		} else if(result >= 0.20 && result < 0.40) {
			
			System.out.println("result >= 1/5 && result < 2/5");	
			
		} else if(result >= 0.40 && result < 0.60) {
			
			System.out.println("result >= 2/5 && result < 3/5");	
			
		} else if(result >= 0.60 && result < 0.80) {
			
			System.out.println("result >= 3/5 && result < 4/5");
			
		} else {
			
			System.out.println("result >= 4/5 && result <= 5/5");
		}
		
		//System.out.println(result);
	}
}
