package bonus02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// On récupère le mot entré par l'utilisateur
		Scanner lect = new Scanner(System.in);
		System.out.println("Entrez un mot: ");
		String mot = lect.next();
		
		// initialisation d'un boolean pour le test
		boolean isPalindrome = true;
		
		for (int i = 0 ; i < mot.length() ; i++) {
			if (mot.charAt(i) != mot.charAt(mot.length() - i - 1)) {
				isPalindrome = false;
				break;
			}
		}
		
		if (isPalindrome) {
			System.out.println("C'est un palindrome!");
		} else {
			System.out.println("Ce n'est pas un palindrome!");
		}
		lect.close();
	}

}
