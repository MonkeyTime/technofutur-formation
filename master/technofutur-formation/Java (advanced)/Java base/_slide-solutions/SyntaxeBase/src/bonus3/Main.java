package bonus3;

import java.util.Scanner;

/**
 * Comptage de caract�res
 * @author Malvoisin Benjamin
 *
 */
public class Main {

	public static void main(String args[]) {
		// On r�cup�re la phrase de l'utilisateur
		Scanner lect = new Scanner(System.in);
		System.out.println("Encodez une phrase: ");
		String phrase = lect.nextLine();
		
		// Transformation du String en tableau de char
		char []phraseChar = new char[phrase.length()];
		for (int i = 0 ; i < phraseChar.length ; i++) {
			phraseChar[i] = phrase.charAt(i);
		}
		
		/* *** CARACTERES *** */
		System.out.println("Liste des caract�res: ");
		char caractere;
		
		// initialisation d'un compteur
		int nb = 0;
		
		// Pour les caract�res allant de ' ' � '�' (voir table ASCII)
		for (caractere = ' ' ; caractere <= '�' ; caractere++) {
			// Pour chaque caract�re de la phrase
			for (int i = 0 ; i < phraseChar.length ; i++) {
				// Test d'�quivalence de caract�re
				if (phraseChar[i] == caractere) {
					// Incr�mentation du compteur
					nb++;
				}
			}
			// Si le caract�re a �t� trouv� au moins une fois
			if (nb > 0) {
				// Affichage
				System.out.println("Le nombre de " + caractere + " est de " + nb);
				// R�initialisation du compteur
				nb = 0;
			}
		}
		
		/* *** LETTRES *** */
		System.out.println("Liste des lettres: ");
		char lettre;
		
		// initialisation d'un compteur
		nb = 0;
		
		// Pour les caract�res allant de 'A' � '�' (voir table ASCII)
		for (lettre = 'A' ; lettre <= '�' ; lettre++) {
			
			// On ignore les carac�tres qui ne sont pas des lettres (voir table ASCII)
			if ('Z' < lettre && lettre < 'a' || 'z' < lettre && lettre < '�') {
				continue;
			}
			
			// Pour chaque caract�re de la phrase
			for (int i = 0 ; i < phraseChar.length ; i++) {
				// Test d'�quivalence de caract�re
				if (phraseChar[i] == lettre) {
					// Incr�mentation du compteur
					nb++;
				}
			}
			// Si le caract�re a �t� trouv� au moins une fois
			if (nb > 0) {
				// Affichage
				System.out.println("Le nombre de " + lettre + " est de " + nb);
				// R�initialisation du compteur
				nb = 0;
			}
		}
		lect.close();
	}
}
