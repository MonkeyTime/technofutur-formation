package alternativesexercice02;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

		Random rand = new Random();
		int nb = rand.nextInt(101);
		
		System.out.println("Le nombre généré est : " + nb);
		
		if (nb % 2 == 0) {
			System.out.println("Divisible par 2");
		}
		if (nb % 3 == 0) {
			System.out.println("Divisible par 3");
		}
		if (nb % 5 == 0) {
			System.out.println("Divisible par 5");
		}
		if (nb % 2 != 0 && nb % 3 != 0 && nb % 5 != 0) {
			System.out.println("Not divisible");
		}
	}

}
