package packexceptions;

public class ExceptionEtatMalDefini extends Exception {
	private static final long serialVersionUID = 1L;

	public ExceptionEtatMalDefini(String prenom, String nom) {
		super("L'état de santé de " + prenom + " " + nom + " est mal défini.");
	}
}
