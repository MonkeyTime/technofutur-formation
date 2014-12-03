package iterativesexercice06;

import java.util.Random;

/**
 * Calcul de la s�quence de Fibonacci
 * @author Malvoisin Benjamin
 *
 */
public class Main {

	public static void main(String[] args) {
		
		// G�n�ration d'un nombre al�atoire compris en 2 et 20
		Random rand = new Random();
		int nb = rand.nextInt(19) + 2;
		System.out.println("Le nombre g�n�r� al�atoirement est : " + nb);
		
		// Initialisation des 2 premi�res valeurs de la suite
		int n0 = 0;
		int n1 = 1;
		System.out.println("F(0) : " + n0);
		System.out.println("F(1) : " + n1);
		
		// Initialisation par d�faut
		int n2 = 0;
		
		// Calcul de la suite
		// 3 = 1 + 2
		// 5 = 2 + 3
		// 8 = 3 + 5
		// => le nouvel est �l�ment est la somme des deux pr�c�dents
		for (int i = 2 ;  i <= nb ; i++) {
			n2 = n0 + n1;	
			n0 = n1;		
			n1 = n2;
			System.out.println("F(" + i + ") : " + n2);
		}
		
		System.out.println("Le r�sultat de la s�quence de Fibonacci de ce nombre est : " + n2);
	}

}
