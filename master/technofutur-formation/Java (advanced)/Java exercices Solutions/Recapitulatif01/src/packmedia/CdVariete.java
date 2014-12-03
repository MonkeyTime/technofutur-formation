package packmedia;

public class CdVariete extends CdMusical {

	private boolean disqueDor;
	
	public CdVariete(String titre, String duree, String auteur, int nombrePistes, boolean disqueDor) {
		// Appel au constructeur protected de la super-classe
		super(titre, duree, 0.3, auteur, nombrePistes);
		this.disqueDor = disqueDor;
	}
	
	public CdVariete(String titre, String duree, String auteur, int nombrePistes) {
		// Appel au constructeur ci-dessus
		this(titre, duree, auteur, nombrePistes, false);
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append("\n");
		builder.append((disqueDor ? "Disquer d'or":"Pas de disque d'or"));
		return builder.toString();
	}
}
