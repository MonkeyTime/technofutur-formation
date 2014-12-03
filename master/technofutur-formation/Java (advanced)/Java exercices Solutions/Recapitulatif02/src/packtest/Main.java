package packtest;

import packexceptions.ExceptionCategorie;
import packexceptions.ExceptionEtatMalDefini;
import packexceptions.ExceptionHopitalComplet;
import packexceptions.ExceptionMedecinComplet;
import packexceptions.ExceptionPersonneDejaPresente;
import packexceptions.ExceptionPersonneNonOperable;
import packinterfaces.EtatSante;
import packinterfaces.SpecialiteChirurgicale;
import packmodele.Chirurgien;
import packmodele.Hopital;
import packmodele.Medecin;
import packmodele.Patient;
import packmodele.Personne;
import packserialisation.Serialisation;

public class Main {

	public static void main(String[] args) {

		Hopital hopital = new Hopital();
		Patient p1;
		Patient p2;
		Chirurgien chirurgien = null;
		int[] categories = { SpecialiteChirurgicale.PNEUMOLOGIE,
				SpecialiteChirurgicale.UROLOGIE };
		Medecin medecin = new Medecin("MacGonagall", "Minerva", "04/09/1930");

		//Serialisation.ouvrirFlux("hopital.dat");

		try {
			p1 = new Patient("Granger", "Hermione", "12/10/1990",
					EtatSante.A_DIAGNOSTIQUER);
			//Serialisation.ecrireObjet(p1);
			
			p2 = new Patient("Londubat", "Neville", "28/11/1990",
					EtatSante.A_OPERER);
			//Serialisation.ecrireObjet(p2);
			
			System.out.println("Etat de Londubat: " + p2.getEtatSanteString());
			System.out.println();
			
			chirurgien = new Chirurgien("Dumbledore", "Albus", "05/04/1901",
					categories);
			medecin.ajouterPatient(p1);
			medecin.ajouterPatient(p2);
			chirurgien.ajouterPatient(p2);
			hopital.ajouter(p1);
			hopital.ajouter(p2);
			hopital.ajouter(medecin);
			hopital.ajouter(chirurgien);
			System.out.println(p1);
			System.out.println(medecin);
			System.out.println(chirurgien);
			try {
				System.out.println();
				hopital.ajouter(p1);
			} catch (ExceptionPersonneDejaPresente e) {
				System.out.println(e.getMessage());
			}
			try {
				System.out.println();
				chirurgien.ajouterPatient(p2);
			} catch (ExceptionPersonneDejaPresente e) {
				System.out.println(e.getMessage());
			}
			System.out.println();
			chirurgien.ajouterPatient(p1);
		} catch (ExceptionEtatMalDefini e) {
			System.out.println(e.getMessage());
		} catch (ExceptionCategorie e) {
			System.out.println(e.getMessage());
		} catch (ExceptionPersonneNonOperable e) {
			System.out.println(e.getMessage());
		} catch (ExceptionPersonneDejaPresente e) {
			System.out.println(e.getMessage());
		} catch (ExceptionHopitalComplet e) {
			System.out.println(e.getMessage());
		} catch (ExceptionMedecinComplet e) {
			System.out.println(e.getMessage());
		} finally {
			/*Serialisation.ecrireObjet(medecin);
			Serialisation.ecrireObjet(chirurgien);
			Serialisation.ecrireObjet(hopital);*/
			
			System.out.println("\nListe des médecins de l'hôpital:");
			System.out.println("--------------------------------");
			Personne[] tabM = hopital.getListeMedecins();
			for (int i = 0 ; i < tabM.length ; i++) {
				if (tabM[i] == null) {
					break;
				}
				System.out.println(tabM[i].toStringCourt());
			}
			
			System.out.println("\nListe des patients de l'hôpital:");
			System.out.println("--------------------------------");
			Personne[] tabP = hopital.getListePatients();
			for (int i = 0 ; i < tabP.length ; i++) {
				if (tabP[i] == null) {
					break;
				}
				System.out.println(tabP[i].toStringCourt());
			}
			try {
				System.out.println();
				int[] categoriesBidon={1,2,100};
				Chirurgien imposteur = new Chirurgien("Imposteur", "Bidon", "15/11/1941", categoriesBidon);
				Serialisation.ecrireObjet(imposteur);
			} catch (ExceptionCategorie e) {
				System.out.println(e.getMessage());
			}
			/*Serialisation.fermerFlux();
			
			System.out.println();
			System.out.println("------------------");
			System.out.println("Test sérialisation");
			System.out.println("------------------");
			System.out.println();
			Serialisation.lireFichier("hopital.dat");*/
		}

	}

}
