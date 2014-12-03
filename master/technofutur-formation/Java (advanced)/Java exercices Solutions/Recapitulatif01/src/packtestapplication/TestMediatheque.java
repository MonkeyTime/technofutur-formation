package packtestapplication;

import packmedia.CdMusical;
import packmedia.CdVariete;
import packmedia.Dvd;
import packmediatheque.Mediatheque;
import packmembre.Membre;

public class TestMediatheque {

	public static void main(String[] args) {

		Mediatheque mediatheque = new Mediatheque("TechnofuturTIC");
		
		System.out.println("**********mediatheque.ajouterMembre()**********");
		Membre membre = new Membre("Wesley", "Ron");
		System.out.println(mediatheque.ajouterMembre(membre));
		Membre membre2 = new Membre("Londubat", "Neville");
		System.out.println(mediatheque.ajouterMembre(membre2));
		System.out.println();
		
		System.out.println("**********mediatheque.ajouterMedia()**********");
		CdMusical cd = new CdMusical("La neuvième", "Beethoven", "53:23", 3);
		System.out.println(mediatheque.ajouterMedia(cd));
		CdMusical cd2 = new CdMusical("Les 4 saisons", "Vivaldi", "42:09", 4);
		System.out.println(mediatheque.ajouterMedia(cd2));
		
		Dvd dvd = new Dvd("Astérix et Cléopatre", "2:23:43", 1);
		System.out.println(mediatheque.ajouterMedia(dvd));
		Dvd dvd2 = new Dvd("Thalassa", "50:32", 0);
		System.out.println(mediatheque.ajouterMedia(dvd2));
		Dvd dvd3 = new Dvd("Envoyé spécial", "1:03:43", 0);
		System.out.println(mediatheque.ajouterMedia(dvd3));
		
		CdVariete cdVariate = new CdVariete("Miss Metéores", "50:13", "Olivia Ruiz", 13, true);
		System.out.println(mediatheque.ajouterMedia(cdVariate));
		CdVariete cdVariate2 = new CdVariete("L'embellie", "54:32", "Calogero", 12);
		System.out.println(mediatheque.ajouterMedia(cdVariate2));
		System.out.println();
		
		System.out.println("**********System.out.println(mediatheque)**********");
		System.out.println(mediatheque);
		System.out.println();
		
		System.out.println("**********System.out.println(mediatheque.getMedias())**********");
		System.out.println(mediatheque.getMedias());
		System.out.println();
		
		System.out.println("**********System.out.println(membre.ajouterLocation())**********");
		System.out.println(membre.ajouterLocation(dvd, "23/06/2008", 5));
		System.out.println(membre.ajouterLocation(cd, "23/06/2008", 10));
		System.out.println(membre.ajouterLocation(cdVariate, "23/06/2008", 2));
		System.out.println(membre.ajouterLocation(dvd, "23/06/2008", 5));
		System.out.println();
		
		System.out.println("**********System.out.println(membre)**********");
		System.out.println(membre);
		System.out.println();
		
		System.out.println("Prix des locations de " + membre.getPrenom() + " " + membre.getNom());
		System.out.println(mediatheque.calculerPrixLocations(membre));
		System.out.println();
		
		System.out.println("**********System.out.println(membre.ajouterLocation())**********");
		System.out.println(membre.ajouterLocation(dvd2, "23/06/2008", 2));
		System.out.println(membre.ajouterLocation(cd2, "23/06/2008", 4));
		System.out.println(membre.ajouterLocation(dvd3, "23/06/2008", 1));
		System.out.println();
		
		System.out.println("**********System.out.println(membre)**********");
		System.out.println(membre);
		System.out.println();
		
		System.out.println("Prix des locations de " + membre.getPrenom() + " " + membre.getNom());
		System.out.println(mediatheque.calculerPrixLocations(membre));
		System.out.println();
		
		System.out.println("**********System.out.println(mediatheque.getMedias())**********");
		System.out.println(mediatheque.getMedias());
		System.out.println();
		
		System.out.println("**********System.out.println(mediatheque.getMediasDisponibles())**********");
		System.out.println(mediatheque.getMediasDisponibles());
		System.out.println();
	}

}
