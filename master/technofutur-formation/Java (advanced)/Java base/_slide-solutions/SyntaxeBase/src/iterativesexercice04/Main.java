package iterativesexercice04;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Entrez un nombre: ");
		int nb = scan.nextInt();
		
		for (int i = 1 ; i <= nb ; i++) {
			boolean estPremier = true;
			
			// j = ] 1, i [
			for (int j = 2 ; j < i ; j++) {
				if (i % j == 0) {
					estPremier = false;
					break;
				}
			}
			
			// if (estPremier == true) {
			if (estPremier) {
				System.out.println(i);
			}
		}
		
		scan.close();
	}
}
