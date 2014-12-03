package packexceptions;

public class ExceptionMedecinComplet extends Exception {
	private static final long serialVersionUID = 1L;

	public ExceptionMedecinComplet(String prenom, String nom) {
		super("Le médecin " + prenom + " " + nom + " a atteint le nombre maximal de patients.");
	}
}
