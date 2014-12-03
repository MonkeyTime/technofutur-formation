package packmembre;

import packmedia.Media;

public class Location {

	private Media media;
	private String date;
	private int nombreJours;
	
	public Location(Media media, String date, int nombreJours) {
		this.media = media;
		this.media.setDisponible(false);
		this.date = date;
		this.nombreJours = nombreJours;
	}
	
	public double calculerPrix() {
		double prix = media.getPrixJournalierLocation() * nombreJours;
		if (nombreJours >= 7) {
			prix *= 0.8;
		}
		return prix;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder("Location ");
		builder.append(media.getClass().getSimpleName());
		builder.append("\n	Titre: ");
		builder.append(media.getTitre());
		builder.append("\n	Début de location: ");
		builder.append(date);
		builder.append("\n	Durée de location: ");
		builder.append(nombreJours);
		builder.append(" jours");
		return builder.toString();
	}
}
