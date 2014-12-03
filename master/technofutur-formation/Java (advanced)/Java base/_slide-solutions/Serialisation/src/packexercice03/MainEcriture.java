package packexercice03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MainEcriture {
	
	public static void main(String args[]) {
		Personne p1 = new Personne("Toto", "Tutu", "10/05/1998");
		Personne p2 = new Personne("Tata", "Tete", "07/09/1991");
		
		FileOutputStream fos;
		ObjectOutputStream out = null;
		
		try {
			fos = new FileOutputStream("objet.dat");
			out = new ObjectOutputStream(fos);
			out.writeObject(p1);
			out.writeObject(p2);
		} catch (FileNotFoundException e) {
			System.err.println("Erreur ouverture fichier");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
