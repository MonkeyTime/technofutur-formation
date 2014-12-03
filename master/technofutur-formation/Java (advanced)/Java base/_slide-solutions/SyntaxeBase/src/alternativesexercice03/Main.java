package alternativesexercice03;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		int VAL_MAX = 100;
		int VAL_MIN = 40;
		
		Random rand = new Random();
		int cote = VAL_MIN + rand.nextInt(VAL_MAX - VAL_MIN);
		
		System.out.print("Côte: " + cote + " ");
		switch (cote / 10) {
		case 9 :
			System.out.print("A");
			break;
		case 8 :
			System.out.print("B");
			break;
		case 7 :
			System.out.print("C");
			break;
		case 6 :
			System.out.print("D");
			break;
		default :
			System.out.print("F");
		}
		
		switch (cote % 10) {
		case 0 :
		case 1 :
			System.out.print("-");
			break;
		case 8 :
		case 9 :
			System.out.print("+");
			break;
		}
	}

}
