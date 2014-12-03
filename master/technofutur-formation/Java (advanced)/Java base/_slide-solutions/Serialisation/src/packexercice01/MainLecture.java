package packexercice01;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainLecture {

	public static void main(String[] args) {

		Scanner scanString = new Scanner(System.in);
		
		System.out.println("Nom du fichier: ");
		String nomFichier = scanString.nextLine();

		FileInputStream fis;
		DataInputStream in = null;
		
		try {
			// Associer le fichier à un flux de lecture
			fis = new FileInputStream(nomFichier);
			// Autoriser la lecture de type primitifs dans le flux de lecture
			in = new DataInputStream(fis);
			
			while (in.available() > 0) {
				System.out.println(in.readInt());
			}
		} catch (EOFException e) {
			System.out.println("Fin du fichier");
		} catch (FileNotFoundException e) {
			System.err.println("Fichier introuvable!!!!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	
		} 
	}

}
