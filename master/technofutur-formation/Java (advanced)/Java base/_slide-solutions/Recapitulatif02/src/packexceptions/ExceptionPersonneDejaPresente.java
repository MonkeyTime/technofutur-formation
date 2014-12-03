package packexceptions;

public class ExceptionPersonneDejaPresente extends Exception {
	private static final long serialVersionUID = 1L;

	public ExceptionPersonneDejaPresente(String prenom, String nom) {
		super(prenom + " " + nom + " est déjà présent sur la liste de l'hôpital");
	}
}
