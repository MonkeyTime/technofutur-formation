package packexercice03;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MainLecture {

	public static void main(String args[]) {
		
		FileInputStream fos;
		ObjectInputStream in = null;
		
		try {
			fos = new FileInputStream("objet.dat");
			in = new ObjectInputStream(fos);
			while (true) {
				Personne p = (Personne) in.readObject();
				System.out.println(p);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Erreur ouverture fichier");
		} catch (EOFException e) {
			System.out.println("Fin de fichier");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("Classe non trouvée!!!!");
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
