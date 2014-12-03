package packexercice2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		boolean estCorrect = false;
		while (!estCorrect) {
			System.out.print("Entrer un réel : ");
			try {
				double nombre = scanner.nextDouble();
				estCorrect = true;
				System.out.println("Le nombre est " + nombre);
			} catch (Exception ex) {
				System.out.println("Nombre incorrect");
			} finally {
				scanner.nextLine();
			}
		}
		scanner.close();	 
	}
}
