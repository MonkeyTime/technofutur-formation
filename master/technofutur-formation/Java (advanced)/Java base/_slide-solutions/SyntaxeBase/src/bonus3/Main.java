package bonus3;

import java.util.Scanner;

/**
 * Comptage de caractères
 * @author Malvoisin Benjamin
 *
 */
public class Main {

	public static void main(String args[]) {
		// On récupère la phrase de l'utilisateur
		Scanner lect = new Scanner(System.in);
		System.out.println("Encodez une phrase: ");
		String phrase = lect.nextLine();
		
		// Transformation du String en tableau de char
		char []phraseChar = new char[phrase.length()];
		for (int i = 0 ; i < phraseChar.length ; i++) {
			phraseChar[i] = phrase.charAt(i);
		}
		
		/* *** CARACTERES *** */
		System.out.println("Liste des caractères: ");
		char caractere;
		
		// initialisation d'un compteur
		int nb = 0;
		
		// Pour les caractères allant de ' ' à 'Ñ' (voir table ASCII)
		for (caractere = ' ' ; caractere <= 'Ñ' ; caractere++) {
			// Pour chaque caractère de la phrase
			for (int i = 0 ; i < phraseChar.length ; i++) {
				// Test d'équivalence de caractère
				if (phraseChar[i] == caractere) {
					// Incrémentation du compteur
					nb++;
				}
			}
			// Si le caractère a été trouvé au moins une fois
			if (nb > 0) {
				// Affichage
				System.out.println("Le nombre de " + caractere + " est de " + nb);
				// Réinitialisation du compteur
				nb = 0;
			}
		}
		
		/* *** LETTRES *** */
		System.out.println("Liste des lettres: ");
		char lettre;
		
		// initialisation d'un compteur
		nb = 0;
		
		// Pour les caractères allant de 'A' à 'Ü' (voir table ASCII)
		for (lettre = 'A' ; lettre <= 'Ü' ; lettre++) {
			
			// On ignore les caracètres qui ne sont pas des lettres (voir table ASCII)
			if ('Z' < lettre && lettre < 'a' || 'z' < lettre && lettre < 'Ç') {
				continue;
			}
			
			// Pour chaque caractère de la phrase
			for (int i = 0 ; i < phraseChar.length ; i++) {
				// Test d'équivalence de caractère
				if (phraseChar[i] == lettre) {
					// Incrémentation du compteur
					nb++;
				}
			}
			// Si le caractère a été trouvé au moins une fois
			if (nb > 0) {
				// Affichage
				System.out.println("Le nombre de " + lettre + " est de " + nb);
				// Réinitialisation du compteur
				nb = 0;
			}
		}
		lect.close();
	}
}
