package alternativesexercice04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Entrez le 1e nombre: ");
		double nb1 = scan.nextDouble();
		System.out.println("Entrez un op�rateur (+,-,*,/): ");
		String operateur = scan.next();
		System.out.println("Entrez le 2e nombre: ");
		double nb2 = scan.nextDouble();
		
		double resultat = 0;
		switch (operateur) {
			case "+" :
				resultat = nb1 + nb2;
				break;
			case "-" :
				resultat = nb1 - nb2;
				break;
			case "*" :
				resultat = nb1 * nb2;
				break;
			case "/" :
				resultat = nb1 / nb2;
				break;
		}
		
		System.out.println("Le r�sultat vaut : " + resultat);
		
		scan.close();
	}

}
