package be.technofutur.moyenne;
import java.util.Random;

public class Moyenne {

	public static void main(String[] args) {
		
		double rand = 0.0;
		
		Random Random = new Random();
		
		for(int i = 1; i <= 5; i++) {
			
			rand = Random.nextInt(101);
			
			rand += rand;

		}
		
		System.out.println("Moyenne = " + (rand / 5));
	}

}
