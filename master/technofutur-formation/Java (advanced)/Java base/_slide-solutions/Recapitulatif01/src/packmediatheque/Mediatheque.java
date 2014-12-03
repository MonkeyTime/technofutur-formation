package packmediatheque;

import packmedia.Media;
import packmembre.Membre;

public class Mediatheque {

	private String nom;
	private Membre[] listeMembres;
	private Media[] listeMedias;
	private static final int NB_MAX_MEMBRES = 100, NB_MAX_MEDIAS = 5000;
	
	public Mediatheque(String nom) {
		this.setNom(nom);
		listeMembres = new Membre[NB_MAX_MEMBRES];
		listeMedias = new Media[NB_MAX_MEDIAS];
	}
	
	public String getMedias() {
		StringBuilder buffer = new StringBuilder("Liste des m�dias: \n");
		for (int i = 0 ; i < listeMedias.length ; i++) {
			if (listeMedias[i] == null) {
				break;
			}
			buffer.append(listeMedias[i].toString() + "\n");
		}
		return buffer.toString();
	}
	
	public String getMediasDisponibles() {
		StringBuilder buffer = new StringBuilder("Liste des m�dias: \n");
		for (int i = 0 ; i < listeMedias.length ; i++) {
			if (listeMedias[i] == null) {
				break;
			}
			if (!listeMedias[i].isDisponible()) {
				continue;
			}
			buffer.append(listeMedias[i].toString() + "\n");
		}
		return buffer.toString();
	}
	
	public double calculerPrixLocations(Membre m) {
		for (int i = 0 ; i < listeMembres.length ; i++) {
			if (listeMembres[i] == null) {
				// Membre non trouv�
				return 0;
			}
			if (listeMembres[i].equals(m)) {
				return m.calculerPrixLocations();
			}
		}
		// Membre non trouv�
		return 0;
	}
	
	public boolean ajouterMembre(Membre m) {
		for (int i = 0 ; i < listeMembres.length ; i++) {
			if (listeMembres[i] == null) {
				// Membre non trouv�
				listeMembres[i] = m;
				return true;
			}
			if (listeMembres[i].equals(m)) {
				// Membre trouv�
				return false;
			}
		}
		return false;
	}
	
	public boolean ajouterMedia(Media m) {
		for (int i = 0 ; i < listeMedias.length ; i++) {
			if (listeMedias[i] == null) {
				// M�dia non trouv�
				listeMedias[i] = m;
				return true;
			}
			if (listeMedias[i].equals(m)) {
				// M�dia trouv�
				return false;
			}
		}
		return false;
	}
	
	public boolean retirerMembre(Membre m) {
		for (int i = 0 ; i < listeMembres.length ; i++) {
			if (listeMembres[i] == null) {
				// Membre non trouv�
				return false;
			} else if (listeMembres[i].equals(m)) {
				// Membre trouv�
				int j;
				for (j = i ; j < listeMembres.length ; j++) {
					if (listeMembres[j] == null) {
						// Fin du d�calage
						break;
					}
					// D�calage des membres pour �viter les emplacements vides
					listeMembres[j] = listeMembres[j + 1];
				}
				// Si jamais la liste �tait remplie, le dernier membre n'aura pas �t� supprim� dans la boucle
				listeMembres[listeMembres.length - 1] = null;
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder("Liste des membres: \n");
		for (int i = 0 ; i < listeMembres.length && listeMembres[i] != null ; i++) {
			builder.append(listeMembres[i].infoMin() + "\n");
		}
		builder.append("\n");
		builder.append(getMedias());
		return builder.toString();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
