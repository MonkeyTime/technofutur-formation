package be.technofutur.devinette;
import java.util.Random;
import java.util.Scanner;

public class Devinette {

	public static void main(String[] args) {
		
		int rand = 0;
		int nbr = 0;
		int MAX_COUNT = 10;
		
		Random Random = new Random();
		
		rand = Random.nextInt(101);
		
		for(int i = 1; i <= MAX_COUNT; i++) {
			
			System.out.println("Choisissez un nombre entre 1 et 100\n");
			Scanner Scan = new Scanner(System.in);
			nbr = Scan.nextInt();
				
			if(i != MAX_COUNT) {
				
				if(nbr < rand) {
					
					System.out.println("C'est +\n");
						
				} else if (nbr > rand) {
						
					System.out.println("C'est -\n");
						
				} else {
						
					System.out.println("C'est gagné\n");
						
					break;
				}
				
			} else {
				
				System.out.println("Perdu\n");
			}
		}
	}

}
