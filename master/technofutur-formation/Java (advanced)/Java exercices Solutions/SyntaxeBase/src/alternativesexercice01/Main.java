package alternativesexercice01;

import java.util.Random;


public class Main {

	public static void main(String[] args) {

		Random rand = new Random();
		double value = rand.nextDouble();

		System.out.println("Le nombre généré" + " est : " + value);

		if (value < (double) 1 / 5) {
			System.out.println("1e quintile");
		} else if (value < 2 / (double) 5) {
			System.out.println("2e quintile");
		} else if (value < 3. / 5) {
			System.out.println("3e quintile");
		} else if (value < 4 / 5.) {
			System.out.println("4e quintile");
		} else {
			System.out.println("5e quintile");
		}

		int valueInt = (int) (value * 5);
		System.out.println(valueInt);
		switch (valueInt) {
		case 0:
			System.out.println("1e quintile");
			break;
		case 1:
			System.out.println("2e quintile");
			break;
		case 2:
			System.out.println("3e quintile");
			break;
		case 3:
			System.out.println("4e quintile");
			break;
		case 4:
			System.out.println("5e quintile");
			break;
		default:
			System.out.println("PROBLEM!!!!");
		}
	}
}
