package iterativesexercice02;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		
		int somme = 0;
		for (int i = 1 ; i <= 5 ; i++) {
			int nb = rand.nextInt(101);
			somme += nb;
			System.out.println(nb);
		}
		
		double moyenne = (double) somme / 5;
		System.out.println("Moyenne: " + moyenne);
	}

}
