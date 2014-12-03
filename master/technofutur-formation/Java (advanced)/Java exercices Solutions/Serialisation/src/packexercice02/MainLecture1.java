package packexercice02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MainLecture1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Nom du fichier: ");
		String nomFichier = scan.nextLine();

		FileReader fr;
		scan.close();
		try {
			fr = new FileReader(nomFichier);
			scan = new Scanner(fr);
			while (scan.hasNext()) {
				String phrase = scan.nextLine();
				System.out.println(phrase);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Fichier non trouvé");
		} finally {
			scan.close();
		}
	}
}
