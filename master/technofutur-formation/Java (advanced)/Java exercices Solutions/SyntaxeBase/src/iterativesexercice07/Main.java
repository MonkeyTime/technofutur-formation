package iterativesexercice07;

import java.util.Random;

/**
 * Calcul de triplets de Pythagore
 * @author Malvoisin Benjamin
 *
 */
public class Main {

	public static void main(String[] args) {
		
		// D�claration et initialisation des variables repr�sentant a, b, c, a�, b�, c�
		int a, b, c, a2, b2, c2;
		a = b = c = a2 = b2 = c2 = 0;
		
		// Nombre al�atoire
		Random rand = new Random();
		
		//D�claration et initialisation d'un compteur
		int i = 1;
		
		// Compteur d'essais
		int nbEssais = 0;
		
		// On veut 8 r�sultats
		while (i <= 8) {
			nbEssais++;
			
			// G�n�ration al�atoire de a, b et c
			a = rand.nextInt(100) + 1;
			b = rand.nextInt(100) + 1;
			c = rand.nextInt(100) + 1;
			
			// Calcul des a�, b� et c�
			a2 = a * a;
			b2 = b * b;
			c2 = c * c;
			
			if (a2 + b2 == c2) {
				System.out.println(i + ") " + a + ", " + b + ", " + c + "\t" + a2 + " + " + b2 + " = " + c2);
			} else {
				// On recommence la boucle sans incr�menter le compteur
				continue;
			}
			
			// Incr�mentation du compteur uniquement si un r�sultat a �t� trouv�
			i++;
		}
		
		System.out.println("Nombre total d'essais : " + nbEssais);
	}

}
