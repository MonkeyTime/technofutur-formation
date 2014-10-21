package be.technofutur.tableau;
import java.util.Scanner;

public class Tableau {

	public static void main(String[] args) {
		
		int[] arrayInt;
		int nbr;
		
		Scanner Scan = new Scanner(System.in);
		
		System.out.println("Choisissez le nbr de case du tableau\n");
		nbr = Scan.nextInt();
		
		arrayInt = new int[nbr];
		
		for(int i = 0; i < arrayInt.length; i++) {
			
			System.out.println("Choisissez un nombre à placer dand le tableau\n");
			nbr = Scan.nextInt();
			
			arrayInt[i] = nbr;
		}
		
		Scan.close();
		
		for(int i = 0; i < arrayInt.length; i++) {
			
			System.out.println(arrayInt[i] + "\n");
		}
	}

}
