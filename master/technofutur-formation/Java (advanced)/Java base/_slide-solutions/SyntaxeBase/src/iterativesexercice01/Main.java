package iterativesexercice01;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		int nb = rand.nextInt(21);
		long facto = 1;
		
		for (int i = 1 ; i <= nb ; i++) {			
			facto *= i;
		}
		
		System.out.println(nb + "! = " + facto);
		
		facto = 1;
		
		int i = 1;
		while(i <= nb) {
			facto *= i;
			i++;
		}
		
		System.out.println(nb + "! = " + facto);
		
		facto = 1;
		
		i = 1;
		do {
			facto *= i;
			i++;
		} while(i <= nb);
		
		System.out.println(nb + "! = " + facto);
	}

}
