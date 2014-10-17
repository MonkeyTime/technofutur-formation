package be.technofutur.calculatrice;
import java.util.Scanner;

/**
 * Calculatrice
 * 
 * class basic calculatrice
 * 
 * @author forma1311
 *
 */
public class Calculatrice {

	/**
	 * main
	 * 
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
			
		int nbr1 = 0;
		int nbr2 = 0;
		int result = 0;
		String op = "";
		
		Scanner Scan = new Scanner(System.in);
		System.out.print("Choisissez un nombre:\n");
		nbr1 = Scan.nextInt();
		System.out.print("Choisissez une opération (+, -, *, /)\n");
		op = Scan.next();
		System.out.print("Choisissez un nombre:\n");
		nbr2 = Scan.nextInt();
		
		switch(op) {
		
			case("+"):
				result = nbr1 + nbr2;
			break;
			
			case("-"):
				result = nbr1 - nbr2;
			break;
			
			case("*"):
				result = nbr1 * nbr2;
			break;
			
			case("/"):
				
				if(nbr2 == 0) {
					
					System.out.print("Division par zero !\n");
					
					break;
				}
			
				result = nbr1 / nbr2;
				
			break;
			
			default:
				return;
		}
		
		System.out.print("Résultat: " + result + "\n");
	}
}
