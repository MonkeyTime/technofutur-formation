package packexercice02;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MainEcriture {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Nom du fichier: ");
		String nomFichier = scan.nextLine();

		FileWriter fw;
		PrintWriter pw = null;

		try {
			fw = new FileWriter(nomFichier);
			pw = new PrintWriter(fw);

			while (true) {
				System.out.println("Entrez du text (\"stop\" pour quitter) :");
				String phrase = scan.nextLine();

				if (phrase.equalsIgnoreCase("stop")) {
					break;
				}

				pw.println(phrase);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Erreur lors de la création du fichier");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {			
			pw.close();
			scan.close();
		}
				
	}
}
