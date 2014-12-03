package tableauexercice01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {		
		Scanner lect = new Scanner(System.in);
		System.out.print("Entrez la longueur du tableau: ");
		int longueur = lect.nextInt();
		
		int[] tab = new int[longueur];
		for (int i = 0 ; i < tab.length ; i++) {
			tab[i] = i;
		}
		
		System.out.print("Tableau : [");
		for (int i = 0 ; i < tab.length ; i++) {
			System.out.print(tab[i]);
			if (i == tab.length - 1) {
				break;
			}
			System.out.print(",");
		}
		System.out.println("]");
		lect.close();
	}

}
