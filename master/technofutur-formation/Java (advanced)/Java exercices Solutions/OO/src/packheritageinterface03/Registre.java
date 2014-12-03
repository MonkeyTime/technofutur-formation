package packheritageinterface03;

public class Registre {

	private Personne[] tab;
	private int nbPersonnes;
	
	public Registre (int taille) {
		tab = new Personne[taille];
		nbPersonnes = 0;
	}
	
	public int getNombrePersonnes() {
		return nbPersonnes;
	}
	
	public void ajouterPersonne(Personne p) {
		if (nbPersonnes < tab.length) {
			tab[nbPersonnes] = p;
			nbPersonnes++;
		}
	}
	
	public String toString() {
		String tmp = "Personnes du registre: \n";
		for (int i = 0 ; i < nbPersonnes ; i++) {
			tmp += (tab[i] + "\n");
		}
		return tmp;
	}
}
