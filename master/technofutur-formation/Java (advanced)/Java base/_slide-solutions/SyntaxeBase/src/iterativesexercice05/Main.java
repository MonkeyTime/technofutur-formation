package iterativesexercice05;

public class Main {

	public static void main (String args[]) {
		int MAX_VALUE = 100;
		
		for (int i = 1 ; i <= MAX_VALUE ; i++) {
			boolean for5 = false;
			boolean for7 = false;
			
			int sommeChiffres = 0;
			int nb = i;		
			while (nb != 0) {
				sommeChiffres += nb % 10;
				nb /= 10;
			} 
			
			if ((i % 5 == 0) || (i % 10 == 5) || (sommeChiffres == 5)) {
				for5 = true;
			}
			
			if (i % 7 == 0 || i % 10 == 7 || (sommeChiffres == 7)) {
				for7 = true;
			}
			
			if (for5 && for7) {
				System.out.println("ding-ding bottle");
			} else if (for5) {
				System.out.println("ding-ding");
			} else if (for7) {
				System.out.println("bottle");
			} else {
				System.out.println(i);
			}
		}
	}
	
	
//	Ecrire les nombres de 1 à 100 en :
//		Remplaçant par « ding-ding », les nombres dont la somme des chiffres qui le composent fait 5
//		Remplaçant par « bottle », les nombres dont la somme des chiffres qui le composent fait 7
//		Remplaçant par « ding-ding bottle », les nombres remplissant les 2 critères ci-dessus

}
