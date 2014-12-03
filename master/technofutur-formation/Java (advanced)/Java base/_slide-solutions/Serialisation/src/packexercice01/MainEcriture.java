package packexercice01;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MainEcriture {

	public static void main(String args[]) {
		
		Scanner scanString = new Scanner(System.in);
		Scanner scanInt = new Scanner(System.in);
		
		System.out.println("Nom du fichier: ");
		String nomFichier = scanString.nextLine();
		
		FileOutputStream fos;
		DataOutputStream out = null;
		
		try {
			// Association du fichier à un flux d'écriture
			fos = new FileOutputStream(nomFichier);
			// Autorisation de l'écriture de type primitifs dans le flux
			out = new DataOutputStream(fos);
			
			int nb;
			while (true) {
				System.out.println("Entrez un entier (0 pour quitter): ");
				nb = scanInt.nextInt();
				
				if (nb == 0) {
					break;
				}
				
				out.writeInt(nb);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Erreur lors de la création du fichier!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
