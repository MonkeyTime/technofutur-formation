package iterativesexercice07;

import java.util.Random;

/**
 * Calcul de triplets de Pythagore
 * @author Malvoisin Benjamin
 *
 */
public class Main {

	public static void main(String[] args) {
		
		// Déclaration et initialisation des variables représentant a, b, c, a², b², c²
		int a, b, c, a2, b2, c2;
		a = b = c = a2 = b2 = c2 = 0;
		
		// Nombre aléatoire
		Random rand = new Random();
		
		//Déclaration et initialisation d'un compteur
		int i = 1;
		
		// Compteur d'essais
		int nbEssais = 0;
		
		// On veut 8 résultats
		while (i <= 8) {
			nbEssais++;
			
			// Génération aléatoire de a, b et c
			a = rand.nextInt(100) + 1;
			b = rand.nextInt(100) + 1;
			c = rand.nextInt(100) + 1;
			
			// Calcul des a², b² et c²
			a2 = a * a;
			b2 = b * b;
			c2 = c * c;
			
			if (a2 + b2 == c2) {
				System.out.println(i + ") " + a + ", " + b + ", " + c + "\t" + a2 + " + " + b2 + " = " + c2);
			} else {
				// On recommence la boucle sans incrémenter le compteur
				continue;
			}
			
			// Incrémentation du compteur uniquement si un résultat a été trouvé
			i++;
		}
		
		System.out.println("Nombre total d'essais : " + nbEssais);
	}

}
