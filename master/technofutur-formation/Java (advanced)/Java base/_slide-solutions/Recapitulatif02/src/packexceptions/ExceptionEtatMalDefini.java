package packexceptions;

public class ExceptionEtatMalDefini extends Exception {
	private static final long serialVersionUID = 1L;

	public ExceptionEtatMalDefini(String prenom, String nom) {
		super("L'�tat de sant� de " + prenom + " " + nom + " est mal d�fini.");
	}
}
