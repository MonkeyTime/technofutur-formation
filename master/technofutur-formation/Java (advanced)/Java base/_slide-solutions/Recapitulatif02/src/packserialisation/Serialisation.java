package packserialisation;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialisation {

	private static ObjectOutputStream out;
	
	public static void ouvrirFlux(String fichier) {
		try { 
			out = new ObjectOutputStream(new FileOutputStream(fichier));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void fermerFlux() {
		try { 
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ecrireObjet(Object o) {
		try { 
			out.writeObject(o);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void lireFichier(String fichier) {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(fichier));
			while(true) {
				Object o = in.readObject();
				System.out.println(o.toString());
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
