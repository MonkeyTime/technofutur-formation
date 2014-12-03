package packheritageinterface05;

public class Main {

	public static void main(String args[]) {
		Adresse adr = new Adresse("Rue du test", 10, 7500, "Tournai");

		CompteCourant c1 = new CompteCourant("1234", "Ben", 2000, 50);
		CompteCourant c2 = new CompteCourant("6789", "Julie", 1500, 50);

		Employe e = new Employe("Malvoisin", "Benjamin", "03/07/1991", adr, c1,
				1550);
		Ouvrier o = new Ouvrier("Caby", "Julie", "12/08/1993", adr, c2, 10);

		int[] hFaitesEmploye = { 170, 158, 165 };
		int[] hAFaireEmploye = { 160, 160, 160 };
		int[] hSemaineOuvrier = { 145, 147 };
		int[] hWEOuvrier = { 3, 5 };

		e.setNbHeures(hFaitesEmploye);
		e.setNbHeuresFaites(hAFaireEmploye);
		o.setNbHeuresSemaine(hSemaineOuvrier);
		o.setNbHeuresWE(hWEOuvrier);
		
		System.out.println(e);
		System.out.println();
		System.out.println(o);
		System.out.println();
		
		e.paiementSalaire();
		o.paiementSalaire();
		
		System.out.println(e);
		System.out.println();
		System.out.println(o);
		System.out.println();
	}
}
