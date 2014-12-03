package packexercice02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainLecture2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Nom du fichier: ");
		String nomFichier = scan.nextLine();

		scan.close();
		FileReader fr;
		BufferedReader br = null;	
		
		try {
			fr = new FileReader(nomFichier);			
			br = new BufferedReader(fr);
			while (true) {
				String phrase = br.readLine();
				if (phrase == null) {
					break;
				}
				System.out.println(phrase);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Fichier non trouvé");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
