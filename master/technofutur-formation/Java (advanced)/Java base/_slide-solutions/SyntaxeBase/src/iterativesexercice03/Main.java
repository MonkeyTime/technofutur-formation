package iterativesexercice03;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int NB_MAX_ESSAIS = 10;
		
		Random rand = new Random();
		int nb = rand.nextInt(100) + 1;
		
		Scanner scan = new Scanner(System.in);		
		
		
		System.out.print("Entrez un nombre: ");
		int essai = scan.nextInt();
		for (int i = 1 ; i < NB_MAX_ESSAIS ; i++) {
			if (essai == nb) {
				System.out.println("Bravo! Vous avez trouvé en " + i + "essais");
				break;
			} 
			System.out.println("Le nombre que vous recherchez est " + ((essai > nb) ? "plus petit." : "plus grand."));
			essai = scan.nextInt();
		}
		
		if (essai != nb) {
			System.out.println("Le nombre recherché était " + nb);
		}
		
		scan.close();
	}
}
