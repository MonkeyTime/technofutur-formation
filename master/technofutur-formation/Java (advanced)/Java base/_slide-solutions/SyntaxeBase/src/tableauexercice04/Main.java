package tableauexercice04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner lect = new Scanner(System.in);
		System.out.print("Entrez n: ");
		int n = lect.nextInt();
		int [][]tab = new int[n][n];
		
		for (int i = 0 ; i < tab.length ; i++) {
			for (int j = 0 ; j < tab[i].length ; j++) {
				if (i == 0) {
					tab[i][j] = j + 1;
				} else if (j == 0) {
					tab[i][j] = i + 1;
				} else {
					tab[i][j] = tab[i][0] * tab[0][j];
				}
			}
		}
		
		for (int i = 0 ; i < tab.length ; i++) {
			for (int j = 0 ; j < tab[i].length ; j++) {
				System.out.print(tab[i][j] + "\t");
			}
			System.out.println();
		}
		lect.close();
	}

}
