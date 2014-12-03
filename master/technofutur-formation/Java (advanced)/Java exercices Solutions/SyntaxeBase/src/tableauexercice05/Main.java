package tableauexercice05;

public class Main {

	public static void main(String[] args) {
		// Création d'un tableau de 9 éléments
		int [][]tab = new int[9][];
		
		for (int i = 0 ; i < tab.length ; i++) {
			// Affectation d'un tableau de i-1 éléments pour tab[i] 
			tab[i] = new int[i + 1];
			// 1e élément de chaque ligne = 1 
			tab[i][0] = 1;
			// dernier élément de chaque ligne = 1
			tab[i][tab[i].length - 1] = 1;
		}
		
		for (int i = 1 ; i < tab.length ; i++) {
			for (int j = 1 ; j < tab[i].length - 1 ; j++) {
				tab[i][j] = tab[i - 1][j - 1] + tab[i - 1][j];
			}
		}
		
		for (int i = 0 ; i < tab.length ; i++) {
			for (int j = 0 ; j < tab[i].length ; j++) {
				System.out.print(tab[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
