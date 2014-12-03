package tableauexercice03;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		Random rand = new Random();
		
//		int []tab = { 0, 1, 2, 3, 4 };
//		int []tab = { 4, 3, 2, 1, 0 };
		int []tab = { 0, 1, 5, 3, 4 };
		
		boolean isCroissant = true;
		boolean isDecroissant = true;
		
		for (int i = 0 ; i < tab.length ; i++) {
			for (int j = i + 1 ; j < tab.length ; j++) {
				if (tab[i] > tab[j]) {
					isCroissant = false;
				}
			}
		}
		
		for (int i = 0 ; i < tab.length ; i++) {
			for (int j = i + 1 ; j < tab.length ; j++) {
				if (tab[i] < tab[j]) {
					isDecroissant = false;
				}
			}
		}
		
		if (isCroissant) {
			System.out.println("Tableau croissant!");
		} else if (isDecroissant){
			System.out.println("Tableau décroissant!");
		} else {
			System.out.println("Ni l'un ni l'autre!");
		}
	}

}
