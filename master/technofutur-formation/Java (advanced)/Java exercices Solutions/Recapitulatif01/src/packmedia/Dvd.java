package packmedia;

public class Dvd extends Media {
	
	private int genre;
	public static final int DOCUMENTAIRE = 0, FILM = 1, SERIE = 2;
	
	public Dvd(String titre, String duree, int genre) {
		super(titre, duree, 0.4);
		
		if (genre == DOCUMENTAIRE || genre == FILM || genre == SERIE) {
			this.genre = genre;
		} else {
			this.genre = FILM;
		}
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append("\nGenre: ");
		builder.append(getGenreString());
		builder.append("\n");
		builder.append((isDisponible() ? "Disponible":"Non disponible"));
		return builder.toString();
	}
	
	public String getGenreString() {
		switch (genre) {
			case DOCUMENTAIRE:
				return "Documentaire";
			case FILM:
				return "Film";
			case SERIE:
				return "Série";
			
			default:
				return "Genre inconnue";
		}
	}
	
}
