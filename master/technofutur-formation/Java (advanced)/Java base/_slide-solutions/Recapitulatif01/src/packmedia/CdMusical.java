package packmedia;

public class CdMusical extends Media {

	private String auteur;
	private int nombrePistes;
	
	public CdMusical(String titre, String auteur, String duree, int nombrePistes) {
		super(titre, duree, 0.34);
		this.auteur = auteur;
		this.nombrePistes = nombrePistes;
	}
	
	// Constructeur appelé uniquement dans la sous-classe CdVariete
	protected CdMusical(String titre, String duree, double prixJournalierLocation, String auteur, int nombrePistes) {
		super(titre, duree, prixJournalierLocation);
		this.auteur = auteur;
		this.nombrePistes = nombrePistes;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append("\nAuteur: ");
		builder.append(auteur);
		builder.append("\nNombre de pistes: ");
		builder.append(nombrePistes);
		builder.append("\n");
		builder.append((isDisponible() ? "Disponible":"Non disponible"));
		return builder.toString();
	}
}
