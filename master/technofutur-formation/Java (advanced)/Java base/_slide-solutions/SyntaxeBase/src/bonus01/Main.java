package bonus01;

import java.util.Scanner;

/**
 * Triangle isocèle avec des *
 * @author Malvoisin Benjamin
 *
 */
public class Main {

		public static void main(String args[]) {
			
			// Récupération de la hauteur du triangle
			Scanner lect = new Scanner(System.in);
			System.out.print("Encodez la hauteur du triangle : ");
			int h = lect.nextInt();
			
			for (int numLigne = 1 ; numLigne <= h ; numLigne++) {
				// Le nombre d'espaces avant une ligne est égal au
				// nombre de lignes situées en dessous de cette ligne
				// ex: h = 6, 4e ligne 
				// 	=> 2 lignes en dessous 
				// 	=> 2 espaces devant la 4e ligne
				for (int j = h - numLigne ; j > 0 ; j--) {
					System.out.print(" ");
				}
				// ligne 1 => 1 étoile => j < 2
				// ligne 2 => 3 étoiles => j < 4
				// ligne 3 => 5 étoiles => j < 6
				// ...
				for (int j = 1 ; j < 2 * numLigne ; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			lect.close();
		}
}
