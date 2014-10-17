package be.technofutur.factoriel;
import java.util.Random;

public class Factoriel {

	public static void main(String[] args) {
		
		int rand, result = 1;
		
		Random Random = new Random();
		
		rand = Random.nextInt(21);
		
		for(int i = 1; i <= rand; i++) {
			
			result *= i;
		}
		
		System.out.println("Factoriel " + rand + " = " + result);
	}

}
