package packmedia;

public abstract class Media {
	
	private String titre, duree;
	private double prixJournalierLocation;
	private boolean disponible;
	
	public Media(String titre, String duree, double prixJournalierLocation) {
		this.titre = titre;
		this.duree = duree;
		this.prixJournalierLocation = prixJournalierLocation;
		this.disponible = true;		
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder(this.getClass().getSimpleName());
		builder.append(":\n");
		builder.append(titre);
		builder.append(" (");
		builder.append(duree);
		builder.append(")");
		return builder.toString();
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getTitre() {
		return titre;
	}

	public String getDuree() {
		return duree;
	}

	public double getPrixJournalierLocation() {
		return prixJournalierLocation;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Media) {
			Media m = (Media) o;
			return this.titre.equals(m.titre);
		}
		return false;
	}
}
