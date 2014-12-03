package packexceptions;

public class ExceptionPersonneDejaPresente extends Exception {
	private static final long serialVersionUID = 1L;

	public ExceptionPersonneDejaPresente(String prenom, String nom) {
		super(prenom + " " + nom + " est d�j� pr�sent sur la liste de l'h�pital");
	}
}
