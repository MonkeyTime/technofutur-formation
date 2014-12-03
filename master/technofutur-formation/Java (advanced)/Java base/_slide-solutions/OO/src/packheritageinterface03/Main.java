package packheritageinterface03;

public class Main {

	public static void main(String[] args) {

		Registre r = new Registre(3);

		Personne p1 = new Personne("1234567", "Ben");
		Personne p2 = new Personne("1234568", "Ja");
		Personne p3 = new Personne("1234569", "Min");
		
		r.ajouterPersonne(p1);
		r.ajouterPersonne(p2);
		r.ajouterPersonne(p3);
		System.out.println(r);
	}

}
