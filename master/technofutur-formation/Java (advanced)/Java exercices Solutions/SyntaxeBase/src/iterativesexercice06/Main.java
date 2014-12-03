package iterativesexercice06;

import java.util.Random;

/**
 * Calcul de la séquence de Fibonacci
 * @author Malvoisin Benjamin
 *
 */
public class Main {

	public static void main(String[] args) {
		
		// Génération d'un nombre aléatoire compris en 2 et 20
		Random rand = new Random();
		int nb = rand.nextInt(19) + 2;
		System.out.println("Le nombre généré aléatoirement est : " + nb);
		
		// Initialisation des 2 premières valeurs de la suite
		int n0 = 0;
		int n1 = 1;
		System.out.println("F(0) : " + n0);
		System.out.println("F(1) : " + n1);
		
		// Initialisation par défaut
		int n2 = 0;
		
		// Calcul de la suite
		// 3 = 1 + 2
		// 5 = 2 + 3
		// 8 = 3 + 5
		// => le nouvel est élément est la somme des deux précédents
		for (int i = 2 ;  i <= nb ; i++) {
			n2 = n0 + n1;	
			n0 = n1;		
			n1 = n2;
			System.out.println("F(" + i + ") : " + n2);
		}
		
		System.out.println("Le résultat de la séquence de Fibonacci de ce nombre est : " + n2);
	}

}
