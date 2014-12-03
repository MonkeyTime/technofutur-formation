package tableauexercice02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main (String args[]) {
		
		Scanner lect = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("Entrez la longueur du tableau 1 : ");
		int taille1 = lect.nextInt();
		int[] tab1 = new int[taille1];
		for (int i = 0 ; i < tab1.length ; i++) {
			tab1[i] = rand.nextInt(101);
		}
		
		System.out.println("Entrez la longueur du tableau 2 : ");
		int taille2 = lect.nextInt();
		int[] tab2 = new int[taille2];
		for (int i = 0 ; i < tab2.length ; i++) {
			tab2[i] = rand.nextInt(101);
		}
		
		afficherTableau(1, tab1);
		//tab1 = trierTableau(tab1);
		Arrays.sort(tab1);
		afficherTableau(1, tab1);		
		
		afficherTableau(2, tab2);		 
		//tab2 = trierTableau(tab2);
		Arrays.sort(tab2);
		afficherTableau(2, tab2);

		int[] tab3 = new int[tab1.length + tab2.length];
		
		System.arraycopy(tab1, 0, tab3, 0, tab1.length);
		System.arraycopy(tab2, 0, tab3, tab1.length, tab2.length);		
		
		afficherTableau(3, tab3);
		//tab3 = trierTableau(tab3);
		Arrays.sort(tab3);
		afficherTableau(3, tab3);
		lect.close();
	}

	public static int[] trierTableau(int [] tab) {
		for (int i = 0 ; i < tab.length ; i++) {
			for (int j = i + 1 ; j < tab.length ; j++) {
				if (tab[i] > tab[j]) {
					int tmp = tab[i];
					tab[i] = tab[j];
					tab[j] = tmp;
				}
			}
		}
		return tab;
	}
	
	public static void afficherTableau(int num, int [] tab) {
		System.out.print("tab" + num + " : [");
		for (int i = 0 ; i < tab.length ; i++) {
			System.out.print(tab[i]);
			if (i == tab.length - 1) {
				continue;
			}
			System.out.print(",");
		}
		System.out.println("]");
	}
}
